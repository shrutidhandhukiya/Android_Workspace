import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class Signup extends StatefulWidget {
  @override
  State<Signup> createState() => _SignupState();
}

class _SignupState extends State<Signup> {
  String? gender="";

  @override
  Widget build(BuildContext context) {
    ScreenUtil.init(context, designSize: const Size(360, 690));

    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: Text(""),
        backgroundColor: Colors.white,
        elevation: 0,
      ),
      resizeToAvoidBottomInset : false,

      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          children: [
            Expanded(
              child: ListView(
                children: [
                  SizedBox(height: 36.h),
                  Padding(
                    padding: const EdgeInsets.only(left: 11.0),
                    child: const Text("Create Account",style: TextStyle(fontSize:37,color: Colors.orange,fontWeight: FontWeight.w800),),
                  ),

                  Padding(
                    padding: const EdgeInsets.only(left: 15.0,bottom:16.0),
                    child: Text("Welcome to our app,singing to become a part of easily fulfill your daily requirments...",
                      style: TextStyle(fontSize:16,color: Colors.grey,fontWeight: FontWeight.w300),),
                  ),

                  ItemWidget(icon: Icons.account_box_sharp,firstname: "firstname",hintText: "FirstName"),
                  ItemWidget(icon: Icons.account_box_sharp,firstname: "LastName",hintText: "LastName"),
                  ItemWidget(icon: Icons.email,firstname: "Email",hintText: "Email"),
                  ItemWidget(icon: Icons.mobile_friendly_outlined,firstname: "+91",hintText: "Number"),

                  Row(
                    children: [
                      SizedBox(
                        width:8.h,
                      ),
                      Row(
                        children: [
                          Radio(value: "Male",
                              groupValue: "$gender",
                              onChanged: (value){
                                setState(() {
                                  gender=value.toString();
                                });
                              }),Text("Female",style: TextStyle(fontSize: 16.sp),)
                        ],
                      ),
                      SizedBox(
                        width: 12.h,
                      ),
                      Row(
                        children: [
                          Radio(value: "Female",
                              groupValue: "$gender",
                              onChanged: (value){
                                setState(() {
                                  gender=value.toString();
                                });
                              }),Text("Male",style: TextStyle(fontSize: 16.sp),)
                        ],
                      ),
                    ],
                  ),

                ],
              ),
            ),
            Row(
              children: [
                Expanded(
                  child: Container(
                    width: double.infinity,
                    height: 60,
                    child: ElevatedButton(
                      onPressed: () {
                      },
                      child: Text('CREATE ACCOUNT'), // trying to move to the bottom
                    ),
                  ),
                ),
              ],
            )
          ],
        ),
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
             Padding(
               padding: EdgeInsets.symmetric(horizontal: 15),
                 child: TextField(
                   keyboardType: TextInputType.text,
                   textAlignVertical: TextAlignVertical.center,autofocus: true,
                   decoration: InputDecoration(
                       contentPadding:EdgeInsets.symmetric(horizontal: 10.w,vertical: 14.h),
                       prefixStyle: TextStyle(color: Colors.black),
                       prefixIcon:Icon(icon),
                       hintText: "$hintText",
                       hintStyle: TextStyle(color: Colors.grey[400]!),
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
             ),
           ],
         ),
       ],
    ),

  );
}

