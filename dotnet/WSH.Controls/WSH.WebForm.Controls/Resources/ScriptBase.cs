﻿using System;
using System.Collections.Generic;
using System.Text;

namespace WSH.WebForm.Controls
{
    [System.Web.UI.PersistChildren(false)]
    public class ScriptBase
    {
        private bool cache=false;

        public bool Cache
        {
            get { return cache; }
            set { cache = value; }
        }
        private string url;

        public string Url
        {
            get { return url; }
            set { url = value; }
        }
        public ScriptBase(string url,bool cache) {
            this.cache = cache;
            this.url = url;
        }
        public ScriptBase(string url):this(url,false) { 
            
        }
    }
}
