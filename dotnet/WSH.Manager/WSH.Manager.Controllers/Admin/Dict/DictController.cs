using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web.Mvc;
using WSH.Options.Common;
using WSH.Manager.Models;
using WSH.Web.Mvc.Common;
using WSH.Manager.Applications;
using WSH.Web.Common;
using System.IO;
using WSH.Common.Ftp;
using WSH.TransferData.Common;
using WSH.Common;
using WSH.Common.Helper;
using WSH.Web.Common.Attachment;
using System.Xml.Linq;

namespace WSH.Manager.Controllers.Admin
{
    public class DictController : BaseController
    {
        #region ��ʼ��������
        public DictController()
        {
        }
        #endregion

        public ActionResult DictList()
        {

            return View();
        }
        public ContentResult GetListData()
        {
            return Content("{\"totalRecord\":1000,\"rows\":[{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"},{\"name\":\"���ɻ�111\",\"address\":\"�����к������¸۶�·1068���������ı���6¥\"}]}");
        }
        public ContentResult GetDictList()
        {

            return GridResult(0, null);
        }
        public ActionResult DownloadFile()
        {
            //FtpConfig config = FtpConfigManager.GetDefaultConfig();

            string serverFileName = @"F:\WSH.Literature\��¼�ʻ�\�ʻ�.txt";
            WebDownload download = new WebDownload();
            download.DownloadFtpFile("SI/MemberOpen/dc7741b80523436980b1412b7dc5b631.jpg");

            //WebUpload upload = new WebUpload(Request.Files[0]);
            //string newFileName=upload.UploadFtp("SI/MemberOpen");

           

            return View();
        }
    }
}
