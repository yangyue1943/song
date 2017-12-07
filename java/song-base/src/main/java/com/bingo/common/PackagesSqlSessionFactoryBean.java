package com.bingo.common;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LinXiuzi on 2016/10/6.
 */
public class PackagesSqlSessionFactoryBean extends SqlSessionFactoryBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(PackagesSqlSessionFactoryBean.class);
    static final String DEFAULT_RESOURCE_PATTERN = "**/pojo/*.class";

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        ResourcePatternResolver resolver = (ResourcePatternResolver) new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
        typeAliasesPackage = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                ClassUtils.convertClassNameToResourcePath(typeAliasesPackage) + "/" + DEFAULT_RESOURCE_PATTERN;

        LOGGER.debug(typeAliasesPackage);
        try {
            List<String> result = new ArrayList<String>();
            Resource[] resources =  resolver.getResources(typeAliasesPackage);
            if(resources != null && resources.length > 0){
                MetadataReader metadataReader = null;
                for(Resource resource : resources){
                    if(resource.isReadable()){
                        metadataReader =  metadataReaderFactory.getMetadataReader(resource);
                        try {
                            result.add(Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage().getName());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if(result.size() > 0) {
                super.setTypeAliasesPackage(StringUtils.join(result.toArray(), ","));
                for(int i=0;i<result.size();i++){
                    LOGGER.debug("FOUND typeAliases: "+result.get(i).toString());
                }
            }else{
                LOGGER.error("参数typeAliasesPackage:"+typeAliasesPackage+"，未找到任何包");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}