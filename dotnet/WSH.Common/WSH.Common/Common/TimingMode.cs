using System;
using System.Collections.Generic;

namespace WSH.Common
{
    public class TimingMode
    {
        private readonly List<DateTime> _timeList=new List<DateTime>();
        public List<DateTime> TimeList
        {
            get { return _timeList; }
        }

        private readonly DateTime _latestTime;
        public DateTime LatestTime
        {
            get { return _latestTime; }
        }

        public TimingMode(string configStr)
        {
            string[] times = configStr.Split(',');
            DateTime nowDateTime = DateTime.Now;
            if(times.Length>0)
            {
                DateTime execDataTime=DateTime.MaxValue;
                foreach (string s in times)
                {
                    string timeType = s.Substring(0, 1);
                    string timestr = s.Substring(1).Trim();
                    string str;
                    DateTime temp = DateTime.MinValue;
                    switch (timeType)
                    {
                        case "M": // ÿ��ִ��һ��
                            str = nowDateTime.ToString("yyyy-MM-") + timestr;
                            temp = Convert.ToDateTime(str);
                            if (nowDateTime > temp)
                            {
                                str = nowDateTime.AddMonths(1).ToString("yyyy-MM-") + timestr;
                                temp = Convert.ToDateTime(str);
                            }                            
                            break;
                        case "W": // ÿ��ִ��һ�� W 6 HH:SS
                            temp = nowDateTime.AddDays(double.Parse(timestr.Substring(0, 1)) - (double)nowDateTime.DayOfWeek);
                            temp = Convert.ToDateTime(temp.ToString("yyyy-MM-dd") + " " + timestr.Substring(1));
                            if (nowDateTime > temp)
                            {
                                temp = temp.AddDays(7);
                            }
                            break;
                        case "D": // ÿ��ִ��һ��
                            str = nowDateTime.ToString("yyyy-MM-dd ") + timestr;
                            temp = Convert.ToDateTime(str);
                            if (nowDateTime > temp)
                            {
                                str = nowDateTime.AddDays(1).ToString("yyyy-MM-dd ") + timestr;
                                temp = Convert.ToDateTime(str);
                            }
                            break;
                        case "H": // ÿСʱ
                            str = nowDateTime.ToString("yyyy-MM-dd HH:") + timestr;
                            temp = Convert.ToDateTime(str);
                            if (nowDateTime>temp)
                            {
                                str = nowDateTime.AddHours(1).ToString("yyyy-MM-dd HH:") + timestr;
                                temp = Convert.ToDateTime(str);
                            }
                            break;

                        case "I": // ����¼�,��λΪ�� 
                            temp = nowDateTime.AddSeconds(int.Parse(timestr));
                            break;
                        default:
                            break;
                    }
                    _timeList.Add(temp);
                    if(temp<execDataTime)
                    {
                        execDataTime = temp;
                    }
                }
                _latestTime = execDataTime;
            }
        }
    }
}
