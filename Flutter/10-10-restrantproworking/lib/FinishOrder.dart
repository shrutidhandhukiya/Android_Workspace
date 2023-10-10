import 'package:flutter/material.dart';

class FinishOrder extends StatefulWidget {

  @override
  State<FinishOrder> createState() => _FinishOrderState();
}

class _FinishOrderState extends State<FinishOrder> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: Padding(
          padding: const EdgeInsets.only(top: 40.0),
          child: Column(
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text("Nous devons dire,",style: TextStyle(fontSize: 15,color: Colors.black,fontWeight: FontWeight.w600),),
                ],
              ),
              Padding(
                padding: const EdgeInsets.only(top: 11.0),
                child: Text("VOUS AVEZ GRAND CHOIX DE GOUT,",style: TextStyle(fontSize: 17,color: Colors.black,fontWeight: FontWeight.w700),),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 50.0),
                child: Image.asset("assets/order.png",height: 110,width: 110,),
              ),

              Padding(
                padding: const EdgeInsets.only(top: 40.0),
                child: Text("ORDER DE CONFIRMATION"),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 10.0),
                child: Text.rich(
                    TextSpan(
                      text:"hungerz".toUpperCase(),
                      style:TextStyle(color: Colors.black,fontSize: 23,fontWeight: FontWeight.w600),
                      children: [
                        TextSpan(
                          text: "RESTRO".toUpperCase(),
                          style:TextStyle(color: Colors.orange,fontSize: 23,fontWeight: FontWeight.w600),
                        )
                      ],
                    )
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top:15.0),
                child: Text("VOTRE NOURRITURE SERA COMMANDE A VOTRE TABLE"),
              ),
              Text(" ANYTIME SOON.."),
            ],
          ),
        ),
      ),
    );
  }
}
