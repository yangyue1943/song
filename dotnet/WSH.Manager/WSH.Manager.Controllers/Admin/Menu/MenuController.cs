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
    public class MenuController : BaseController
    {
        #region ��ʼ��������
        public MenuController()
        {
        }
        #endregion
        public ActionResult MenuEdit() {
            return View();
        }
         
    }
}
