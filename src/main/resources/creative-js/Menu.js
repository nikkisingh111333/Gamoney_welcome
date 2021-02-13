class Menu{ //PARENT MENU FOR ALL THREE LINE MENUS
	constructor(Id,menuid,data,color_enable,shadow,enable_rotation,position,size=70){
	    this.size=size;
		this.el=data;
		this.pos=position;
		this.en_rotation=enable_rotation;
	    this.canvi=document.getElementById(Id);
        this.canvi.style.position="absolute";
        this.canvi.style.width=`${this.size }px`;
        this.canvi.style.height=`${this.size }px`;
        this.ctx=this.canvi.getContext("2d");
        //console.log(this.canvi.style.width);
        this.xx=1;
        this.yy=450;
        this.y=29;
        this.y2=71;
        this.en_color=color_enable;
        this.moveUpper=80;
        this.rotate=0;
        this.Right=0;
        this.Left=0;	
        this.cmd="move";
        this.menu_id=window.document.getElementById(menuid);
        this.menu_id.style.position="absolute";
        if(this.pos!='left'){
           this.canvi.style.right='0px';
           this.menu_id.style.right="0px";
        }
        this.menu_id.style.overflow="scroll";
        this.menu_id.style.display="none";
        this.elems;
        this.border=2;
        if(shadow!=false){
	        this.ctx.shadowOffsetY=5.9;
            this.ctx.shadowOffsetX=9.0;
            this.ctx.shadowBlur=10.9;
            this.ctx.shadowColor="grey";
            this.ctx.fill();
        }   
        this.COLOR=["darkred","cyan","pink","red","green","blue","yellow","black","lightblue","violet","lightgreen","brown","grey","orange"];//default red
        this.color_changer;
        this.ctx.lineWidth="3";
        this.ctx.moveTo(this.moveUpper,30);
        this.ctx.lineTo(30,this.y); 
        this.ctx.lineCap="round";//upper Line 
        //ctx.fillStyle="lightblue";
        this.ctx.strokeStyle=this.COLOR[this.color_changer];
        this.ctx.stroke();
          //ctx.beginPath();
        this.ctx.lineWidth="3";
        this.ctx.moveTo(30,50);
        this.ctx.lineTo(90,50);
       //ctx.strokeStyle="orange";
        this.ctx.stroke();
        this.ctx.lineWidth="3";
        this.ctx.moveTo(this.moveUpper,70);
        this.ctx.lineTo(30,this.y2);
        this.ctx.strokeStyle=this.COLOR[this.color_changer];
        this.ctx.lineCap="round";
        this.ctx.stroke();
    }
}
class linebars extends Menu{
	
   constructor(Id,menuid,dataList,color_enable=false,shadow=false,enable_rotation=false,position="left",size=70){
	   super(Id,menuid,dataList,color_enable,shadow,enable_rotation,position,size);//best use of super
          this.el=dataList;
          
          for(let data in dataList){
    	      //console.log(data+"___"+dataList[data]);
          }
//this.canvi=document.createElement("canvas");
//this.canvi.id=Id;
//this.canvi.width="100px";
//this.canvi.height="100px";
//this.canvi.style.border="2px solid";



 this.spin=function(){  //attribute of this object
	
	if(this.Left<=150&&this.cmd=="reverse"){
	     //console.log("m i");
	     this.reverse();
	 //console.log("^"+Left);
	 
	// y-=40;
	//	console.log('stop');
		//anime=requestAnimationFrame(spin);
		//cancelAnimationFrame(anime)
    }
    else{	
	  this.ctx.clearRect(0,0,this.canvi.width,this.canvi.height);
      this.ctx.beginPath();

     // you cant control animation without beginpath () inright manner
	//ctx.rect(x,y,40,40);
	//will create middle line
	this.ctx.lineWidth="3";
	this.ctx.moveTo(this.moveUpper,30);
	this.ctx.lineTo(30,this.y); 
	this.ctx.lineCap="round";//upper Line 
	//ctx.fillStyle="lightblue";
	this.ctx.strokeStyle=this.COLOR[this.color_changer];
	this.ctx.stroke();
	//ctx.beginPath();
	this.ctx.lineWidth="3";
	this.ctx.moveTo(30,50);
	this.ctx.lineTo(90,50);
	//ctx.strokeStyle="orange";
	this.ctx.stroke();
	this.ctx.lineWidth="3";
	this.ctx.moveTo(this.moveUpper,70);
	this.ctx.lineTo(30,this.y2);
	this.ctx.strokeStyle=this.COLOR[this.color_changer];
	this.ctx.lineCap="round";
	this.ctx.stroke();
	if(this.pos=='right'){
		 this.canvi.style.right=`${this.Right}px`;
	     
	}
	else{
		 this.canvi.style.left=`${this.Left}px`;
    }
    if(shadow!=false){
        this.ctx.shadowOffsetY=5.9;
        this.ctx.shadowOffsetX=9.0;
        this.ctx.shadowBlur=10.9;
        this.ctx.shadowColor="grey";
        this.ctx.fill();
    }
    
    this.menu_id.style.display="block";
    this.menu_id.style.width=`${this.xx}px`;
    this.menu_id.style.height=`${this.yy}px`;
    //$this.menu_id.style.border=`${this.border}px solid`;
    this.xx+=7;
    this.yy+=3;
    this.Left+=1;
	this.Right+=1;
	this.y+=1;
	this.y2-=1;
	
    this.moveUpper-=1;
	
		//console.log(y);
	//	console.log(y2);
		//moveDiper+
		var[c,d]=[1,0];
	    if(this.Left==20&&this.cmd=="move"||this.Right==20&&this.cmd=="move"){
		   // console.log(this.canvi.style.right);
	       if(this.pos=='right'){
       		
       	   this.Right+=130;
	          this.canvi.style.right=`${this.Right}px`;
	       }
	       else{
      		
	           this.Left+=130;
	           this.canvi.style.left=`${this.Left}px`;
      	 }
		   this.elems=this.menu_id.childNodes;
		   //console.log(this.canvi.style.left);
		   // console.log(this.elems.length);
		   for(c=1;c<this.elems.length;c+=2){
		      //this.elems[c].href=this.el.data;
  			
  			 //************DEBUG point********
  			 if(this.elems [c].childNodes[0]) {
   				
   			    this.elems[c].childNodes[0].innerHTML=this.el[d];
  		         c+=1;
  		     }
  		     else {
       			this.elems[c].innerHTML=this.el[d];
       	       c+=1;
       	    }
  			d+=1;
  		 }
		
		   this.cmd="reverse";
		   if(this.en_color!=false){
			  this.color_changer=Math.floor(Math.random()*12);
		   }
		
	    }
	    else{
    		
	 	  if(this.en_rotation!=false){
	 	    if(this.rotate!=181){
	 	    	
                 this.canvi.style.transform=`rotate(${this.rotate}deg)`;
                 this.rotate+=10;
             }
             else{
             }
           }

	        requestAnimationFrame(this.spin.bind(this));
	       // use bind() to change the scope of the defined function inside other object
	   }
	}
 
 }
 this.reverse=function(){
	
	this.ctx.clearRect(0,0,this.canvi.width,this.canvi.height);
        this. ctx.beginPath(); // you cannot control canvas animation without beginpath () inright manner
	//ctx.rect(x,y,40,40);
        this. ctx.lineWidth="3";
	this.ctx.moveTo(30,50);
	this.ctx.lineTo(90,50);
	//ctx.strokeStyle="orange";
	this.ctx.stroke(); //will create middle line
	this.ctx.lineWidth="3";
	this.ctx.moveTo(this.moveUpper,30);
	this.ctx.lineTo(30,this.y); 
	this.ctx.lineCap="round";//upper Line 
	//ctx.fillStyle="lightblue";
	this.ctx.strokeStyle=this.COLOR[this.color_changer];
	this.ctx.stroke();
	//ctx.beginPath();
	this.ctx.lineWidth="3";
	this.ctx.moveTo(this.moveUpper,70);
	this.ctx.lineTo(30,this.y2);
	this.ctx.strokeStyle=this.COLOR[this.color_changer];
	this.ctx.lineCap="round";
	this.ctx.stroke();
	if(this.pos=='right'){
		this.Right-=1;
		this.canvi.style.right=`${this.Right}px`;
	}
	else{
		
		this.canvi.style.left=`${this.Left}px`;
	    this.Left-=1;
    }
    
    for(let c=1;c<this.elems.length;c+=2){
    	if(this.elems [c].childNodes[0]){
    	 // this.elems[c].childNodes[0].innerHTML="";
        }
        else{
        	this.elems [c].innerHTML="";
        }
  
    }
	   this.menu_id.style.width=`${this.xx}px`;
	   this.menu_id.style.height=`${this.yy}px`;			
		this.xx-=7;
		this.yy-=3;
		
		
	    this.y-=1;
		this.y2+=1;
		this.moveUpper+=1;
       if(shadow!=false){
       	
       
	  this.ctx.shadowOffsetY=5.9;
          this.ctx.shadowOffsetX=9.0;
          this.ctx.shadowBlur=10.9;
          this.ctx.shadowStyle="grey";
          this.ctx.stroke();
       }
       if(this.y==29&&this.y2==71){
	    this.cmd="move";
	    if(this.pos!="left"){
               this.Right-=130;
	       this.menu_id.style.display="none";
	       this.canvi.style.right=`${this.Right}px`;
			
	    }
	    else{
	       this.Left-=130;
               this.menu_id.style.display="none";
	       this.canvi.style.left=`${this.Left}px`;
            }
	}
	else{
			
           if(this.en_rotation!=false){
	 	    if(this.rotate!=370){
     			
     		
     			 this.canvi.style.transform=`rotate(${this.rotate}deg)`;
                         //console.log("rotated"+this.rotate);
                         this.rotate+=10;
                    }
                    else{
             	         this.rotate=0;
                    }
           }
	       requestAnimationFrame(this.spin.bind(this));//bind is use to bind class instance to its member function calling on global scope
	 }
   }
 
 }
}
//var datalist=["♡lober","☆light","₩goku","$nikki","&to","€beast","£hai"];
//var menubar=new linebars("canV","menu",datalist,true,true,true,"left",'70');