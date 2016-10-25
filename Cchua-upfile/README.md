# spring-boot

###spring-boot上次传文件的实现


---


这里主要用到了MultipartFile来进行文件上传 


MultipartFile类常用的一些方法就不详细的说了

测试地址:
http://127.0.0.1:8080/fiel.html

接口地址
http://127.0.0.1:8080/uploads



###Ps:
多文件上传其实很简单，表单中使用相同的名称，然后action中将MultipartFile参数类定义为数组就可以，然后用循环把文件一个个上传，这里还引用了UUID 防止文件的冲突，如果有需要重命名同时加上文件后缀名的，需要获取下后缀名，重命名的时候把文件后缀名加上去就可以了。





