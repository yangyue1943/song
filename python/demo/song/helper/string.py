import re

"""
判断字符串是否是字符串或者空格
"""


def isempty(s):
    if not s or s.isspace():
        return True
    else:
        return False


"""
将字符串转为int
"""
def cint(s, defaultValue=0):
    try:
        return int(s)
    except:
        return defaultValue


def pint(s, defaultValue=0):
    try:
        return int(re.sub("\D", "", s))
    except:
        return defaultValue
