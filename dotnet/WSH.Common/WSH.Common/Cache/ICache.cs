
namespace WSH.Common.Cache
{
    /// <summary>
    /// ����ӿ�
    /// </summary>
    public interface ICache<T>
    {
        /// <summary>
        /// ����KEY�õ�����
        /// </summary>
        /// <param name="itemKey">KEY</param>
        /// <returns></returns>
        T Get(string key);

        /// <summary>
        /// �Ƴ�����
        /// </summary>
        /// <param name="itemKey"></param>
        void Remove(string key);

        /// <summary>
        /// д�뻺��
        /// </summary>
        /// <param name="itemKey">KEY</param>
        /// <param name="value">VALUE</param>
        /// <param name="cacheDurationInSeconds">��������</param>
        void Insert(string key, T value, int cacheDurationInSeconds);

        /// <summary>
        /// д�뻺��(��������)
        /// </summary>
        /// <param name="itemKey">KEY</param>
        /// <param name="value">VALUE</param>
        void Insert(string key, T value);

    }
}