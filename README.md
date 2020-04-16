# login-svc

This is the backend of the android project

# development history


# docker
https://dzone.com/articles/deploying-spring-boot-on-docker



cd  /var/local/git/android/login-svc

mvn clean package -Dmaven.test.skip=true

docker build -f DockerFile -t android/login-svc .


		Sending build context to Docker daemon  39.24MB
		Step 1/4 : FROM java:8
		 ---> d23bdf5b1b1b
		Step 2/4 : EXPOSE 8080
		 ---> Running in 61a04c436a6b
		Removing intermediate container 61a04c436a6b
		 ---> d58c24d826a6
		Step 3/4 : ADD /target/login-svc-0.1.jar login-svc-0.1.jar
		 ---> 058828913eaa
		Step 4/4 : ENTRYPOINT ["java","-jar","login-svc-0.1.jar"]
		 ---> Running in a49dd79b1cbb
		Removing intermediate container a49dd79b1cbb
		 ---> cd54d19b12f8
		Successfully built cd54d19b12f8
		Successfully tagged android/login-svc:latest


docker images

		REPOSITORY                        TAG                 IMAGE ID            CREATED             SIZE
		android/login-svc                 latest              cd54d19b12f8        2 minutes ago       682MB


docker run -d -it --restart always --name login-svc -p 8080:8080 --net cims-network android/login-svc



docker logs login-svc --tail 1000




erictan@erictan /v/l/g/a/login-svc> docker logs login-svc --tail 1000

```log
			  .   ____          _            __ _ _
			 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
			( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
			 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
			  '  |____| .__|_| |_|_| |_\__, | / / / /
			 =========|_|==============|___/=/_/_/_/
			 :: Spring Boot ::        (v2.2.6.RELEASE)

			2020-04-14 09:34:19.734  INFO 1 --- [           main] com.eric.service.ServiceApplication      : Starting ServiceApplication v0.1 on 707a6fa06b0d with PID 1 (/login-svc-0.1.jar started by root in /)
			2020-04-14 09:34:19.739  INFO 1 --- [           main] com.eric.service.ServiceApplication      : No active profile set, falling back to default profiles: default
			2020-04-14 09:34:20.959  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
			2020-04-14 09:34:21.006  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 28ms. Found 0 JPA repository interfaces.
			2020-04-14 09:34:22.340  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
			2020-04-14 09:34:22.365  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
			2020-04-14 09:34:22.365  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.33]
			2020-04-14 09:34:22.500  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
			2020-04-14 09:34:22.500  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2678 ms
			2020-04-14 09:34:22.869  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
			2020-04-14 09:34:23.694  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
			2020-04-14 09:34:23.807  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
			2020-04-14 09:34:23.929  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.12.Final
			2020-04-14 09:34:24.185  INFO 1 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
			2020-04-14 09:34:24.386  INFO 1 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
			2020-04-14 09:34:24.823  INFO 1 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
			2020-04-14 09:34:24.840  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
			2020-04-14 09:34:24.941  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
			2020-04-14 09:34:25.190  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
			2020-04-14 09:34:25.589  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
			2020-04-14 09:34:25.595  INFO 1 --- [           main] com.eric.service.ServiceApplication      : Started ServiceApplication in 6.596 seconds (JVM running for 7.524)
			2020-04-14 09:36:13.285  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
			2020-04-14 09:36:13.286  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
			2020-04-14 09:36:13.299  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 13 ms
```


docker exec -it login-svc /bin/bash


# Kubernetes 

https://www.youtube.com/watch?v=UWg3ORRRF60

https://www.edureka.co/blog/install-kubernetes-on-ubuntu

1. Pre-requisites to install Kubernetes
	
```bash
	$ sudo su
	# apt-get update
```		
Turn Off Swap Space

```bash
	# swapoff -a
	# nano /etc/fstab
	# UUID=...
```

Update the hostname
		
```bash
	# nano /etc/hostname
	kmaster
```		

Update The Hosts File With IPs Of Master & Node
```bash
	# ifconfig
	enp0s3
		inet addr: 10.0.2.15
		
	# nano /etc/hosts
	10.0.2.15	kmaster
	10.0.2.??	knode
	
```
Setting Static IP Addresses
```bash
	# nano /etc/network/interfaces
	
	auto enp0s8
	iface enp0s8 inet static
	address <IP-Address-Of-VM>
```
2. Setting up Kubernetes environment
3. Installing Kubeadm, Kubelet, Kubectl
4. Starting the Kubernetes cluster from master
5. Getting the nodes to join the cluster




'# intefaces (5) file used by ifup(8) and ifdown(8)
auto lo
iface lo inet loopback


---------------------------------------------
	New Ubuntu
---------------------------------------------

	screen resolution 1280 x 800 -> display
		
	smaller menu icon -> appearence

	copy and paste		https://askubuntu.com/posts/792833/revisions
		Updates
		Make sure you have the latest version of VirtualBox.
		It might be good to first sudo apt update and sudo apt upgrade and restart if needed.
		Guest Additions
		Power on virtual machine
		Click "Devices" on the VirtualBox menu at the top of the screen
		Click "Install Guest Additions CD Image..."
		Follow the on-screen prompts as needed, enter your password, etc.
		Restart the virtual machine
		Enable features
		Machine -> Settings -> General -> Advanced -> enable Shared Clipboard and/or Drag'n'Drop.
		Make sure View -> Auto-resize Guest Display is checked.
	
	can network
	
	can usb
	
	
	