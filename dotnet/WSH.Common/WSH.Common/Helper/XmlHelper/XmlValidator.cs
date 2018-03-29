using System;
using System.IO;
using System.Xml;
using System.Xml.Schema;

namespace WSH.Common.Helper
{
    /// <summary>
    /// ʹ��Schema��֤XML�ļ�
    /// </summary>
    public class XmlValidator
    {
        public string ErrorMsg = string.Empty;
        public bool IsValid = true;

        ///<summary>
        /// ����XSD��֤XML�Ƿ���Ϲ淶
        ///</summary>
        ///<param name="entityXML">��Ҫ��֤��XML</param>
        ///<param name="xmlSchema">����XSD��������</param>
        public void Validate(Stream xmlSchema, string entityXML)
        {

            var sr = XmlReader.Create(xmlSchema);
            var schemaSet = new XmlSchemaSet();
            schemaSet.Add(null, sr);
            var doc = new XmlDocument();
            doc.LoadXml(entityXML);
            doc.Schemas = schemaSet;
            doc.Validate(ValidationEventHandler);

        }

        ///<summary>
        /// ����XSD��֤XML�Ƿ���Ϲ淶,�ַ���У��
        ///</summary>
        ///<param name="entityXML">��Ҫ��֤��XML</param>
        ///<param name="xmlSchema">����XSD��������</param>
        public void Validate(string xmlSchema, string entityXML)
        {

            var sr = XmlReader.Create(new StringReader(xmlSchema));
            var schemaSet = new XmlSchemaSet();
            schemaSet.Add(null, sr);
            var doc = new XmlDocument();
            doc.LoadXml(entityXML);
            doc.Schemas = schemaSet;
            doc.Validate(ValidationEventHandler);

        }

        private void ValidationEventHandler(object sender, ValidationEventArgs e)
        {
            ErrorMsg += e.Message + "\r\n";
            IsValid = false;
        }
    }
}