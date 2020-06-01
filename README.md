# Educational-Institute-Database-management-Project
Educational Institute Database Management System Project (This is a specially design for Indian Institute of Information Technology vadodara (IIITV))

There are some important things which you should know about this project before try to run it.


1. please put your user name and password at the place of mine in all the java files.   
   for example : 
   
   this is in my code :    myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
   
   this should your:     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename","Username","Password");
   
2. There is a database in it, you should create it into your device, name of data base is "result" (you can take different).


3 Details of all tables in database. 
                 
	create table studentregistration(  
             ID varchar(10) not null ,
             Sname varchar(50) not null,
             bra	nch varchar(10) not null,
             sem varchar(1) not null,
             sec varchar(1) not null,
             pass varchar(30) not null,
             primary key(ID)
          );
                 
											  
	create table staff(
		empid varchar(20) not null ,
		name varchar(50) not null ,
		pass varchar(30) not null ,
		typ varchar(100) not null,
		primary key(empid)
	);							
													
								
								
	create table Bus(
			days varchar(15) not null ,
			morn varchar(30) ,
			even1 varchar(30) ,
		   even2 varchar(30)
		);					
								
	create table hostel(
		rolno varchar(15) not null ,
		Bno varchar(1) not null ,
		rno varchar(5) not null,
		fee varchar(10),
		md varchar(10),
		Tid varchar(40),
		FOREIGN KEY(rolno) REFERENCES studentRegistration(ID),
		primary key(rolno)
	);						
														
	create table courseenroll(
		rolno varchar(15) not null ,
		coID varchar(10) not null ,
		FOREIGN KEY(rolno) REFERENCES studentRegistration(ID),
		FOREIGN KEY(coID) REFERENCES course(cID),
		primary key(rolno,coID)
	);								
							
	create table courseAssign(
		facID varchar(15) not null ,
		coID varchar(10) not null ,
		sec varchar(1) not null,
		sem varchar(1) not null,
		branch varchar(10) not null,
		FOREIGN KEY(facID) REFERENCES faculty(fID),
		FOREIGN KEY(coID) REFERENCES course(cID),
		primary key(facID,coID,sec,sem)
	);
	
	create table faculty(
		fID varchar(10) not null ,
		fname varchar(50) not null,
		sub varchar(100) ,
		foreign key(fid) references EmpReg(empID),
		primary key(fID)
	);
	
	create table course(
		cID varchar(10) not null ,
		cname varchar(150) not null,
		cred varchar(5) not null,
		primary key(cID)
	);
	
	create table EmpReg(
		empID varchar(10) not null ,
		Ename varchar(50) not null,
		jod date not null,
		lev varchar(1) not null,
		primary key(empID)
	);	
	
	create table TimeTable(
		branch varchar(10) not null ,
		section varchar(1) not null,
		sem varchar(1) not null,
		days varchar(10) not null,
		fstsft  varchar(10),
		sndsft varchar(10), 
		aftrlnch1 varchar(10),
		aftrlnch2 varchar(10)
	);					
													
	create table Btech2(
    branch varchar(10) not null ,
    section varchar(1) not null,
    sem varchar(1) not null,
    days varchar(10) not null,
    fstsft  varchar(10),
    sndsft varchar(10), 
    aftrlnch1 varchar(10),
    aftrlnch2 varchar(10)
	);
	
	create table Btech4(
    branch varchar(10) not null ,
    section varchar(1) not null,
    sem varchar(1) not null,
    days varchar(10) not null,
    fstsft  varchar(10),
    sndsft varchar(10), 
    aftrlnch1 varchar(10),
    aftrlnch2 varchar(10)
	);						
	
									
 
	StudentRegistration :  for registration of students.
               Staff : contains data of all employee who signup.
               Bus   : it contains information about bus schedule.
             Hostel  : contains information of students who live in hostel.
        Courseenroll : which course student will read during current semester
        CourseAssign : courses assign to faculty.
             faculty : faculty information   
              course :  all tthe course details 
              empreg :  employee registration
          Time Table : Academic time table for students.  
          
 
	       


 		









 

   Front: This is a java class in this project where main function is present. I given its name Front because it is face of my project or  leading page. When you run it, it will give you a window, In this window you can login as a student or as a faculty etc.
   
   

   
   


   
       
    
