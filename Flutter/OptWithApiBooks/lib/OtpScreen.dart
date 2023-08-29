import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:pinput/pinput.dart';
import 'package:restaurant/HomeScreen.dart';
import 'package:restaurant/MyBehavior.dart';

class OtpScreen extends StatefulWidget {
  String id = " ";
  String verificationId;
  String number;
  OtpScreen(this.verificationId,this.number);


  @override
  State<OtpScreen> createState() => _OtpScreenState();
}

class _OtpScreenState extends State<OtpScreen> {

  final defaultPinTheme = PinTheme(
      width:56,
      height:56,
      textStyle:TextStyle(fontSize: 20,color: Colors.black,fontWeight: FontWeight.w600),
      decoration: BoxDecoration(
      border: Border.all(color: Color.fromRGBO(234, 239, 243, 1)),
      borderRadius: BorderRadius.circular(20),
    ),
  );

  var OtpController=TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: BackButton(color: Colors.black,),
        title: Text("OTP Verification",style: TextStyle(color: Colors.black),),
      ),
      backgroundColor: Colors.white,
      body: ScrollConfiguration(
        behavior: MyBehavior(),
        child: ListView(
          children: [
            SizedBox(height: 40.h,),
            Center(child: Text("We have sent a verication code to")),
            SizedBox(height: 10.h,),
            Center(child: Text("${widget.number}",style: TextStyle(fontWeight: FontWeight.bold),)),
            SizedBox(height: 40.h,),
            //otp radius logic theme
            Pinput(
              length: 6,
              controller: OtpController,
              defaultPinTheme: defaultPinTheme,
              focusedPinTheme: defaultPinTheme.copyDecorationWith(
                border: Border.all(color: Colors.white),
                borderRadius: BorderRadius.circular(8),
              ),
              submittedPinTheme: defaultPinTheme.copyWith(
                decoration: defaultPinTheme.decoration!.copyWith(
                  color: Color.fromRGBO(234, 239, 243, 1),
                ),
              ),
              validator: (s) {
                //return s == '2222' ? null : 'Pin is incorrect';
              },
              pinputAutovalidateMode: PinputAutovalidateMode.onSubmit,
              showCursor: true,
              onCompleted: (pin)async{
                FirebaseAuth auth = FirebaseAuth.instance;
               try{
                 PhoneAuthCredential credential = PhoneAuthProvider.credential(verificationId: widget.verificationId, smsCode: pin);

                 // Sign the user in (or link) with the credential
                 await auth.signInWithCredential(credential);
                if(auth.currentUser!=null){
                  Navigator.push(context, MaterialPageRoute(builder: (_)=>HomeScreen()));
                }
               }catch(e){

               }

              },
            ),
            SizedBox(height: 20.h,),
            Padding(padding: EdgeInsets.symmetric(horizontal: 10.w),
            child: Row(
              children: [
                // Spacer(),
                Container(
                  decoration: BoxDecoration(
                      border: Border.all(color:Colors.grey[300]!),
                      borderRadius: BorderRadius.circular(10.r)
                  ),
                  child: Padding(
                    padding: EdgeInsets.all(5.h),
                    child: ElevatedButton(
                        style: ButtonStyle(
                          elevation: MaterialStateProperty.all(0),
                          backgroundColor: MaterialStateProperty.all(Colors.white),
                          padding: MaterialStateProperty.all(EdgeInsets.all(10.h)),

                        ),
                        onPressed: (){}, child: Text("Resend SMS in 16",style:TextStyle(color: Colors.grey[300]!))),
                  ),
                ),
                // SizedBox(width: 20.w,),
                //
                // Container(
                //   decoration: BoxDecoration(
                //       border: Border.all(color:Colors.grey[300]!),
                //       borderRadius: BorderRadius.circular(10.r)
                //   ),
                //   child:Padding(
                //     padding:  EdgeInsets.all(5.h),
                //     child: ElevatedButton(
                //         style: ButtonStyle(
                //           elevation: MaterialStateProperty.all(0),
                //           backgroundColor: MaterialStateProperty.all(Colors.white),
                //           padding: MaterialStateProperty.all(EdgeInsets.all(10.h)),
                //         ),
                //         onPressed: (){}, child: Text("Call me in 16",style:TextStyle(color: Colors.grey[300]!))),
                //   ),
                //   ),
                // Spacer(),
              ],
            ),

            ),

          ],
        ),
      ),


    );
  }
}
