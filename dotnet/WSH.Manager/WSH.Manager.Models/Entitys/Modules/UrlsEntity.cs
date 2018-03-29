using System;
using System.Collections.Generic;
using System.Text;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace WSH.Manager.Models
{
	[Table("Urls")]
    public class UrlsEntity : Entity
    {
    	/// <summary>
        /// ����
        /// </summary>
        [Required,StringLength(300)]
        public virtual string Title { get; set; }
    	/// <summary>
        /// ��ҳ��ַ
        /// </summary>
        [Required,StringLength(500)]
        public virtual string Url { get; set; }
    	/// <summary>
        /// ͼ���ַ
        /// </summary>
        [StringLength(500)]
        public virtual string IconUrl { get; set; }
    	/// <summary>
        /// ͼ����
        /// </summary>
        
        public virtual string IconName { get; set; }
    	/// <summary>
        /// ��ע˵��
        /// </summary>
        [StringLength(500)]
        public virtual string Remark { get; set; }
    	/// <summary>
        /// �����
        /// </summary>
        
        public virtual int Hits { get; set; }
        /// <summary>
        /// ��ҳ����
        /// </summary>
        public virtual string Encoding { get; set; }
    	/// <summary>
        /// ����ʱ��
        /// </summary>
        [Required]
        public virtual DateTime CreateTime { get; set; }
    }
}

