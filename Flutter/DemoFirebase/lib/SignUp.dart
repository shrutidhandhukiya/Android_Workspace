import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class SignUp extends StatefulWidget {
  const SignUp({Key? key}) : super(key: key);

  @override
  State<SignUp> createState() => _SignUpState();
}

class _SignUpState extends State<SignUp> {
  String? gender="";
  var name=TextEditingController();
  var email=TextEditingController();
  var password=TextEditingController();
  @override
  Widget build(BuildContext context) {
    ScreenUtil.init(context, designSize: const Size(360, 690));
    return Scaffold(

        appBar: AppBar(
          backgroundColor: Colors.white,
          elevation: 0,
          leading: BackButton(color: Colors.black,),
          title: Text("..", style: TextStyle(color: Colors.white70),),
        ),
        // resizeToAvoidBottomInset : false,
        body: Padding(
          padding: const EdgeInsets.all(8.0),
          child: SingleChildScrollView(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                SizedBox(height: 60,),
                ListView(
                  addRepaintBoundaries: true,
                  addAutomaticKeepAlives: true,
                  // controller: ScrollController(),
                  // scrollDirection: Axis.vertical,
                  physics: ScrollPhysics(),
                  // keyboardDismissBehavior: ScrollViewKeyboardDismissBehavior.onDrag,
                  shrinkWrap: true,
                  children: [
                    Container(
                        padding: const EdgeInsets.only(left: 20.0),
                        child: Text('Create Account',style: TextStyle(fontSize: 30,fontWeight: FontWeight.bold,color: Colors.blue),)),
                    SizedBox(height: 10,),
                    Container(
                      padding: const EdgeInsets.only(left: 20.0,right: 20),
                      child: Text('Welcome to our app,singing to become a part of easily fulfill your daily requirmments....',style: TextStyle(fontSize: 14,color: Colors.grey),),
                    ),
                    SizedBox(height: 10,),
                    ItemWidget(controller:name,name: 'FIRSTNAME', icon: Icons.account_box, hinttext: 'user123@gmail.com'),
                    ItemWidget(name: 'LASTNAME', icon: Icons.ac_unit, hinttext: 'user123@gmail.com'),
                    ItemWidget(controller:email,name: 'EMAIL', icon: Icons.email_outlined, hinttext: 'email'),
                    ItemWidget(name: 'PHONE', icon: Icons.phone_android, hinttext: '+91 9898989898'),
                    ItemWidget(controller:password,name: 'password', icon: Icons.phone_android, hinttext: 'password'),
                    SizedBox(width: 10,),
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Row(
                        children: [
                          Row(
                            children: [
                              Radio(
                                activeColor:Colors.blue,
                                // title:  Text("Male"),
                                value:"Male",
                                groupValue: "$gender",
                                onChanged: (value){
                                  setState(() {
                                    gender=value.toString();

                                  });
                                },
                              ),SizedBox(width: 10,),Text("Male",style: TextStyle(fontWeight:FontWeight.w400,fontSize: 16))
                            ],
                          ),
                          Row(
                            children: [
                              Radio(
                                activeColor:Colors.blue,
                                // title:  Text("Male"),
                                value:"Female",
                                groupValue: "$gender",
                                onChanged: (value){
                                  setState(() {
                                    gender=value.toString();

                                  });
                                },
                              ),SizedBox(width: 10,),Text("Female",style: TextStyle(fontWeight:FontWeight.w400,fontSize: 16))
                            ],
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
                Padding( // this is new
                    padding: EdgeInsets.only(bottom: MediaQuery.of(context).viewInsets.bottom)
                ),
                Align(
                  alignment: Alignment.bottomCenter,
                  child: Container(
                    margin: const EdgeInsets.all(8),
                    width: double.infinity,
                    height: 50,
                    child: ElevatedButton(
                      onPressed: ()async {
                        try {
                          UserCredential userCredential = await FirebaseAuth.instance.createUserWithEmailAndPassword(
                              email: "${email.text}",
                              password: "${password.text}"
                          );
                          if(userCredential.user!=null){
                            //Navigator.push(context, MaterialPageRoute(builder: (_)=>HomeScreen()));

                          }
                        } on FirebaseAuthException catch (e) {
                          if (e.code == 'weak-password') {
                            print('The password provided is too weak.');
                          } else if (e.code == 'email-already-in-use') {
                            print('The account already exists for that email.');
                          }
                        }
                        catch (e)
                        {
                          print(e);
                        }
                      },
                      child: const Text('CREATE ACCOUNT'),
                    ),
                  ),
                )
              ],
            ),
          ),
        )
    );
  }
}
ItemWidget({required String name,required IconData icon,required String hinttext, TextEditingController? controller})
{
  return Container(

    child: Padding(
      padding: const EdgeInsets.only(right: 15,left: 15,top: 20),

      child: TextField(
        controller: controller,
        decoration: InputDecoration(
          border: OutlineInputBorder(),
          prefixIcon: Icon(Icons.password),
          labelText: 'Password',
          hintText: "Enter your Password",
        ),
      ),
    ),

  );
}

/*var name=TextEditingController();
  var email=TextEditingController();
  var password=TextEditingController();

  @override
  Widget build(BuildContext context) {
    ScreenUtil.init(context, designSize: const Size(360, 690));
    return Scaffold(
      appBar: AppBar(
        title: Text(""),
        backgroundColor: Colors.white,
        elevation: 0,
      ),
      resizeToAvoidBottomInset : false,
      body: ListView(
        children: [
          ItemWidget(icon: Icons.account_box, firstname: "firstname", hintText: "hintText"),
          ItemWidget(icon: Icons.account_box, firstname: "firstname", hintText: "hintText"),
          ItemWidget(icon: Icons.account_box, firstname: "firstname", hintText: "hintText"),
        ],
      ),

    );

  }
}
ItemWidget({required IconData icon,required String firstname,required String hintText }){

  return Container(
    child: Column(
      children: [
        Padding(
          padding: const EdgeInsets.all(8),
          child: Center(
              child: Container(
                width: 200,
              )
          ),
        ),
        Column(
          children: [
            TextField(
              keyboardType: TextInputType.text,
              textAlignVertical: TextAlignVertical.center,autofocus: true,
              decoration:InputDecoration(
                contentPadding:EdgeInsets.symmetric(horizontal: 10.w,vertical: 14.h),
                prefixStyle: TextStyle(color: Colors.black),
                prefixIcon:Icon(icon),
              ),
            ),
          ],
        )
      ],
    ),
  );

}*/
