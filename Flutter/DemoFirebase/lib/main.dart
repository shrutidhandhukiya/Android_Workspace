import 'package:demofirebase/HomeScreen.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

Future<void> main() async {
  await  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      debugShowCheckedModeBanner: false,
      home: FirebaseAuth.instance.currentUser!=null?HomeScreen():MyHomePage()
    );
  }
}

class MyHomePage extends StatefulWidget {

  int select=0;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  TextEditingController email=TextEditingController();
  TextEditingController password=TextEditingController();
  TextEditingController confirmpassword=TextEditingController();
  final auth=FirebaseAuth.instance;

  var btnSelect=0;


  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }
  @override
  Widget build(BuildContext context) {
    ScreenUtil.init(context, designSize: const Size(360, 690));
    return Scaffold(
      appBar: AppBar(
        title: Text(""),
      ),
      resizeToAvoidBottomInset : false,

      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Container(
              // color: widget.select ? Colors.blue : Colors.black,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children:List.generate(2, (index) =>    RawMaterialButton(
                  onPressed: () {
                    setState(() {
                      btnSelect=index;
                    });
                  },
                  child: Container(
                    padding:EdgeInsets.all(10),
                    decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(10),
                        border: Border.all(color: Colors.black),
                        color: btnSelect==index?Colors.blue:null
                    ),
                    child: Text(index==0?"Login":"Sign up"),
                  )
                )
                )
              ),
            ),
          ),
          Padding(
           padding: const EdgeInsets.all(8.0),
           child: TextField(
             controller: email,
             keyboardType: TextInputType.emailAddress,
             decoration: InputDecoration(
               contentPadding:EdgeInsets.symmetric(horizontal: 10.w,vertical: 10.h),
               border: OutlineInputBorder(),
               prefixIcon: Icon(Icons.email),
               labelText: 'Email',
               hintText: "Enter your email",
             ),
           ),
         ),
          Padding(
           padding: const EdgeInsets.all(8.0),
           child: TextField(
             controller: password,
             keyboardType: TextInputType.visiblePassword,
             decoration: InputDecoration(
               border: OutlineInputBorder(),
               prefixIcon: Icon(Icons.password),
               labelText: 'Password',
               hintText: "Enter your Password",
             ),
           ),
         ),
          btnSelect==0?Container():Padding(
           padding: const EdgeInsets.all(8.0),
           child: TextField(
             controller: confirmpassword,
             keyboardType: TextInputType.visiblePassword,
             decoration: InputDecoration(
               border: OutlineInputBorder(),
               prefixIcon: Icon(Icons.password),
               labelText: 'confirmPassword',
               hintText: "Enter your confirmPassword ",
             ),
           ),
         ),
          btnSelect==0?Container():Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: confirmpassword,
              keyboardType: TextInputType.visiblePassword,
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                prefixIcon: Icon(Icons.password),
                labelText: 'PhoneNumber',
                hintText: "Enter your PhoneNumber ",
              ),
            ),
          ),
          SizedBox(
            width: double.infinity,
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: ElevatedButton(onPressed: ()async{
                UserCredential? user;
                print("$btnSelect");
                if(btnSelect==0){
                 user=await auth.signInWithEmailAndPassword(email: email.text, password: password.text);
                }else{
                  user=await auth.createUserWithEmailAndPassword(email: email.text, password: password.text)  ;
                }
                if(user!= null){
                  Navigator.pushAndRemoveUntil(context, MaterialPageRoute(builder:(_)=>HomeScreen()), (route) => false);
                }

              }, child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: Text(btnSelect==0?"Login":"Sign up"),
              )),
            ),
          ),

          Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children:List.generate(1, (index) =>    RawMaterialButton(
                  onPressed: () {
                    setState(() {
                      btnSelect=index;
                    });
                  },
                  child: Container(
                    padding:EdgeInsets.all(15),
                    decoration: BoxDecoration(
                        color: btnSelect==index?Colors.white:null
                    ),
                    child: Image.network("https://static-00.iconduck.com/assets.00/google-icon-2048x2048-czn3g8x8.png",width: 50,height: 50,)),
                  )
              )
              ),
        ],
      ),
    );
  }
}
