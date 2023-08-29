
import 'dart:developer';

import 'package:country_list_pick/country_list_pick.dart';
import 'package:firebase_phone_auth_handler/firebase_phone_auth_handler.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:restaurant/MyBehavior.dart';
import 'package:restaurant/OtpScreen.dart';
import 'package:restaurant/Signup.dart';

class LoginScreen extends StatefulWidget {
  String  id= "";

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  var country={"name": "India", "countryCode": "IN", "phoneCode": "+91"};

  var number=TextEditingController();
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.init(context, designSize: const Size(360, 690));
    return Scaffold(
      body: ScrollConfiguration(
       behavior: MyBehavior(),
       child: ListView(
         children: [
           Container(
             height: 270.h,
             width: double.infinity,
           child: Image.asset(
             "assets/images/zomato.jpg",
             fit: BoxFit.fill,
           )
           ),
           SizedBox(
             height: 20,
           ),
           Center(
               child: Text(
                 "India's #1 Food Delivery \n      and Dining App",
                 style: TextStyle(fontSize: 18.sp, fontWeight: FontWeight.w700),
               )),
           SizedBox(
             height: 20.h,
           ),
           Padding(
               padding:EdgeInsets.symmetric(horizontal: 20.w),
              child: Column(
                children: [
                  Row(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.center,
                   children: [
                  Expanded(child: Divider()),
                  SizedBox(
                    width: 10.w,
                  ),
                  Center(child: Text("Log in or sign up")),
                  SizedBox(
                    width: 10.w,
                  ),
                  Expanded(child: Divider()),
                ],
              ),
                  SizedBox(
                    height: 10.h,
                  ),
                  Container(
                    height: 40.h,
                    width: double.infinity,
                    child: Row(
                      children: [
                    Container(
                    decoration:BoxDecoration(
                    borderRadius: BorderRadius.circular(5.r),
                      border: Border.all(color: Colors.grey[300]!)
                  ),
                      child: CountryListPick(
                        appBar: AppBar(
                          backgroundColor: Colors.pink,
                          title: Text('Select Country'),
                        ),
                        pickerBuilder: (context,CountryCode? countryCode){
                          return Row(
                            children: [
                              Image.asset(
                                countryCode!.flagUri!,
                                package: 'country_list_pick',
                              ),
                              Icon(Icons.expand_more,color: Colors.grey,)
                            ],
                          );
                        },
                        // To disable option set to false
                        theme: CountryTheme(
                          isShowFlag:true,
                          isShowTitle: false,
                          isShowCode: false,
                          isDownIcon: true,
                          showEnglishName: true,
                        ),
                        initialSelection: '+91',
                        // or
                        // initialSelection: 'US'
                        onChanged: (CountryCode? code){
                          setState(() {
                            country= {"name":"${code!.name}","countryCode": "${code!.code}", "phoneCode": "${code!.dialCode}"};
                          });
                        },
                        // Whether to allow the widget to set a custom UI overlay
                        useUiOverlay: true,
                        // Whether the country list should be wrapped in a SafeArea
                        useSafeArea: false,
                        ),
                      ),
                        SizedBox(
                          width: 19.w,
                        ),

                        Expanded(
                            child: TextField(
                              controller: number,
                              keyboardType: TextInputType.number,
                              textAlignVertical: TextAlignVertical.center,autofocus: true,
                              decoration: InputDecoration(
                                contentPadding:EdgeInsets.symmetric(horizontal: 10.w,vertical: 10.h),
                                prefixText: "${country['phoneCode']}",
                                prefixStyle: TextStyle(color: Colors.black),
                                hintText: "Enter Phone Number",
                                hintStyle: TextStyle(color: Colors.grey[300]!),
                                enabledBorder:  OutlineInputBorder(
                                    borderSide:
                                    BorderSide(width: 1, color: Colors.grey[300]!)),
                                  border: OutlineInputBorder(
                                      borderSide:
                                      BorderSide(width: 1, color: Colors.grey[300]!)),
                                  focusedBorder:OutlineInputBorder(
                                      borderSide:
                                      BorderSide(width: 1, color: Colors.grey[300]!))
                              ),
                            )
                        )
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 10.h,
                  ),
                  Container(
                    width: double.infinity,
                    child: ElevatedButton(
                      style: ButtonStyle(
                          padding: MaterialStateProperty.all(
                              EdgeInsets.all(15.h))),


                      onPressed: ()async{

                        showDialog(context: context,
                            builder: (ctx)=>AlertDialog(
                                insetPadding: EdgeInsets.symmetric(horizontal: 150),
                                contentPadding: EdgeInsets.zero,
                                clipBehavior: Clip.antiAliasWithSaveLayer,
                                shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.all(Radius.circular(10.0))
                                ),
                                content:  Container(
                                  height: 100,width: 50,
                                  decoration: BoxDecoration(
                                    borderRadius: BorderRadius.circular(100),
                                    color: Colors.white,
                                  ),
                                  child: Stack(
                                    children: [
                                      Center(
                                        child: SizedBox(
                                            height:60,width: 60,
                                            child: CircularProgressIndicator()),
                                      ),
                                      Center(
                                        child: SizedBox(
                                            height:40,width: 50,
                                            child: Center(child: Image.network("https://images.saymedia-content.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cq_auto:eco%2Cw_1200/MTc0MTk2ODg3NDkzMDI3MzI0/how-to-upload-android-apps-for-free.gif",fit: BoxFit.fill,))),
                                      ),


                                    ],
                                  ),

                                )
                            )
                        );
                        // Navigator.push(context,MaterialPageRoute(builder: (_)=>Provider()));

                        FirebaseAuth auth = FirebaseAuth.instance;
                        await auth!.verifyPhoneNumber(
                          phoneNumber: '${country['phoneCode']}${number.text}',
                          codeSent: (String verificationId, int? resendToken) async {

                            Navigator.pop(context);
                            Navigator.push(context, MaterialPageRoute(builder: (_)=>OtpScreen(verificationId,"${country['phoneCode']}${number.text}")));
                          },
                          verificationCompleted: (PhoneAuthCredential phoneAuthCredential) {  },
                          verificationFailed: (FirebaseAuthException error) {
                            Navigator.pop(context);
                          },
                          codeAutoRetrievalTimeout: (String verificationId) {  },
                        );


                      },

                    child: Text("Continue"),),
                  ),
                  SizedBox(
                    height: 10.h,
                  ),
                  Row(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Center(
                          child: Text("OR")),
                    ],
                  ),
                  SizedBox(
                    height: 10.h,
                  ),

                  GestureDetector(

                    onTap: (){
                      Navigator.push(context, MaterialPageRoute(builder: (_)=>Signup()));
                    },
                    child: Row(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Center(
                            child: Padding(
                              padding: const EdgeInsets.all(11),
                              child: Text("SignUp",style: TextStyle(fontSize: 18),),

                            )),
                      ],
                    ),
                  ),


                  /*SizedBox(
                    height: 10.h,
                  ),
                  Row(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Expanded(child: Divider()),
                      SizedBox(
                        width: 10.w,
                      ),
                      Center(child: Text("or")),

                      SizedBox(
                        width: 10.w,
                      ),
                      Expanded(child: Divider()),
                    ],
                  ),
                  SizedBox(
                    height: 10.h,
                  ),
                  Row(
                    children: [
                      Spacer(),
                      Container(
                        decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(50),
                            border: Border.all(color: Colors.grey[300]!),
                            color: Colors.white),
                        child: IconButton(
                          onPressed: (){

                          },
                            icon: Image.asset("assets/images/ic_google.png")),
                        ),
                        Spacer(),

                      Container(
                        decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(50),
                            border: Border.all(color: Colors.grey[300]!)),

                        child: IconButton(
                          onPressed: (){
                            showModalBottomSheet(
                              isDismissible: false,
                              backgroundColor: Colors.transparent,
                                context: context,
                                builder: (BuildContext context){
                                return Container(
                                    height:  300.h,
                                  child: Stack(
                                    children: [
                                      Column(
                                        children: [
                                          Expanded(child: Container(color: Colors.transparent,)),
                                          Container(
                                            decoration:BoxDecoration(
                                                borderRadius: BorderRadius.circular(10.r),
                                                color: Colors.white
                                            ),
                                            child: Column(
                                              children: [
                                                SizedBox(height: 20.h,),
                                                Padding(padding: EdgeInsets.symmetric(horizontal: 10.0.w),
                                                  child: Container(
                                                    width:double.infinity,
                                                    child: ElevatedButton.icon(
                                                      style: ButtonStyle(
                                                        padding: MaterialStateProperty.all(EdgeInsets.symmetric(vertical:20.h)),
                                                        elevation:MaterialStateProperty.all(0),
                                                        backgroundColor:MaterialStateProperty.all(Colors.white),
                                                        shape: MaterialStateProperty.all<
                                                        RoundedRectangleBorder>(
                                                          RoundedRectangleBorder(
                                                        borderRadius:
                                                        BorderRadius
                                                            .circular(18.0),side: BorderSide(color:Colors.grey[300]!),
                                                          )
                                                        )
                                                      ),
                                                        onPressed: (){},
                                                        icon: Icon(Icons.facebook,
                                                          color: Colors.blue,),
                                                        label:Text("Continue with Faceboook",style: TextStyle(color: Colors.black),)),
                                                   ),

                                                  ),
                                                SizedBox(height: 20.h,),
                                                Padding(padding: EdgeInsets.symmetric(horizontal: 10.0.w),
                                                  child: Container(
                                                    width: double.infinity,
                                                    child: ElevatedButton.icon(
                                                        style: ButtonStyle(
                                                            padding:MaterialStateProperty.all(EdgeInsets.symmetric(vertical:20.h)),
                                                            elevation:MaterialStateProperty.all(0),
                                                            backgroundColor:MaterialStateProperty.all(Colors.white),
                                                            shape: MaterialStateProperty.all<
                                                                RoundedRectangleBorder>(
                                                                RoundedRectangleBorder(
                                                                    borderRadius:
                                                                    BorderRadius
                                                                        .circular(18.0),
                                                                    side: BorderSide(
                                                                        color:
                                                                        Colors.grey[300]!)))),
                                                        onPressed: (){},
                                                        icon: Icon(
                                                          Icons.email,
                                                          color: Colors.black,
                                                        ),
                                                        label: Text("Continue with Email",style: TextStyle(color: Colors.black),)),
                                                     ),
                                                  ),
                                                SizedBox(height: 20.h,)
                                              ],
                                            ),
                                          )
                                        ],
                                      ),
                                      Positioned(
                                          top: 20.h,
                                          left: 170.w,
                                          child: Container(
                                            decoration: BoxDecoration(
                                              color: Colors.black,
                                              borderRadius: BorderRadius.circular(50)
                                            ),
                                            child: Center(
                                              child: IconButton(
                                                color: Colors.black,
                                                onPressed: (){
                                                  Navigator.pop(context);
                                                }, icon: Icon(Icons.cancel_outlined,color: Colors.white,),
                                              ),
                                            ),
                                          )
                                      )
                                    ],
                                  ),
                                );
                                });
                          }, icon: Icon(Icons.more_vert)),
                        ),
                      Spacer(),
                    ],
                  ),*/

                  SizedBox(
                    height: 10.h,
                  ),
                  Text("By continuing,you agree to our"),
                  Text("Term of service  Privacy Policy  Content Policy"),

                ],
              ),
           )
         ],
       ),
      ),
    );
  }
}









