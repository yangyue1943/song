﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WSH.DataAccess.Dapper
{
    /// <summary>
    /// 忽略字段
    /// </summary>
    [AttributeUsage(AttributeTargets.Field | AttributeTargets.Property)]
    public class IgnoreAttribute:BaseAttribute
    {
    }
}
