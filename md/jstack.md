# jstack 分析线程卡死问题

- 查找对应的java程序进程
```aidl
ps -ef | grep java
```
- 查看进程下的线程信息，查看运行时间最长的线程号

```aidl
ps p 进程号 -L -o pcpu,pid,tid,time,tname > psp.info
```
- 将thread dump信息保存为文件
- 在jstack.log中查找可能出现问题的类名或等待时间最长的进程号
```aidl
jstack -l 进程号 > jstack.log
```