import 'package:flutter/material.dart';

class ProductDetails extends StatefulWidget {

  @override
  State<ProductDetails> createState() => _ProductDetailsState();
}

class _ProductDetailsState extends State<ProductDetails> {
  bool valuefirst = false;
  bool valuesecond= false;
  bool valuethird=false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Container(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.end,
            crossAxisAlignment: CrossAxisAlignment.end,
            children: [
              Padding(
                padding: const EdgeInsets.only(right:18,top: 6),
                child: ElevatedButton(onPressed: (){},
                  child:Text("items in Cart",style: TextStyle(fontSize: 11,color: Colors.white),),
                  style: ElevatedButton.styleFrom(
                    primary: Colors.red,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(21),
                    ),
                  ),),
              ),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: ClipRRect(
                    borderRadius: BorderRadius.circular(11),
                    child: Container(
                        child: Image.network("https://possible.in/wp-content/uploads/2016/01/04-2.jpg"))),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Padding(
                    padding: const EdgeInsets.only(left: 6.0),
                    child: Text("Cheese Bread",
                      style: TextStyle(fontSize: 13,color: Colors.black,fontWeight: FontWeight.w500),),
                  ),
                ],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Padding(
                    padding: const EdgeInsets.only(left: 6.0),
                    child: Text("Fast Food",
                      style: TextStyle(fontSize: 9,color: Colors.grey,),),
                  ),
                  Spacer(),
                  Column(
                    children: [
                      Padding(
                        padding: const EdgeInsets.only(right:18.0,top: 4.0),
                        child: Text("\$12.00",style: TextStyle(fontSize:14),),
                      ),
                    ],
                  )
                ],),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Padding(
                    padding: const EdgeInsets.only(left: 6.0,top: 6.0),
                    child: Text("ADD OPTIONS",
                      style: TextStyle(fontSize: 11,color: Colors.grey,),),
                  ),
                ],),
              Row(
                children: [
                  Checkbox(
                      value: this.valuefirst,
                      activeColor: Colors.orange,
                      onChanged: (bool? value){
                        setState(() {
                          this.valuefirst=!valuefirst;
                          if(valuefirst=true){
                            valuesecond=false;
                            valuethird=false;
                          }
                        });
                      }),
                  Text("Extra Cheese",style: TextStyle(fontSize: 12),),
                Spacer(),

                Padding(
                  padding: const EdgeInsets.only(right: 18.0),
                  child: Text("\$4.00",style: TextStyle(fontSize: 15),),
                )],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Checkbox(
                      value: this.valuesecond,
                      activeColor: Colors.orange,
                      onChanged: (bool? value){
                        setState(() {
                          this.valuesecond=!valuesecond;
                          if(valuesecond=true){
                            valuefirst=false;
                            valuethird=false;
                          }
                        });

                      }), Text("Extra Cheese",style: TextStyle(fontSize: 12)),
                Spacer(),

                Padding(
                  padding: const EdgeInsets.only(right: 18.0),
                  child: Text("\$4.00",style: TextStyle(fontSize: 15),),
                )],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Checkbox(
                      value: this.valuethird,
                      activeColor: Colors.orange,
                      onChanged: (bool? value){
                        setState(() {
                          this.valuethird=!valuethird;
                          if(valuethird=true){
                            valuefirst=false;
                            valuesecond=false;
                          }
                        });
                      }), Text("Extra Cheese",style: TextStyle(fontSize: 12)),
                  Spacer(),
                  Padding(
                    padding: const EdgeInsets.only(right: 18.0),
                    child: Text("\$4.00",style: TextStyle(fontSize: 15),),
                  )],

              ),
              SizedBox(
                width: double.infinity,
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: ElevatedButton(onPressed: (){

                  }, child: Text("Add to cart",style: TextStyle(fontSize: 11,color: Colors.white),),
                    style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.only(bottomRight: Radius.circular(6),bottomLeft: Radius.circular(6)),
                        )
                    ),
                  ),
                ),
              ),
              Container(
                width: double.infinity,
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(9)
                ),
                child: Column(
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(9.0),
                      child: Text("DESCRIPTION ",style: TextStyle(fontSize:11)),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(11.0),
                      child: Text("Loream ipsum dolor sit amet."
                          "Loream ipsum dolor sit amet"
                          "Loream ipsum dolor sit amet"
                          "Loream ipsum dolor sit amet "),
                    ),
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(11),
                  child: Image.network("https://possible.in/wp-content/uploads/2016/01/04-2.jpg",),),
              ),
              Padding(
                padding: const EdgeInsets.only(left: 22.0,right: 22.0,top: 6.0),
                child: Container(
                  decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(10)
                  ),
                  child:
                  Row(
                    children: [
                      Column(
                        children: [
                          Image.network("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEoecVLOewI7w-TKdAVwN_YWg2k6o1ksqNf11ijwmP&s",width: 30,height: 30,),
                          Text("SERVINGS",style: TextStyle(fontSize: 9,color: Colors.grey),),
                          Text("2 people",style: TextStyle(fontSize: 9,color: Colors.black)),
                        ],
                      ),
                      Spacer(),
                      Column(
                        children: [
                          Image.network("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEoecVLOewI7w-TKdAVwN_YWg2k6o1ksqNf11ijwmP&s",width: 30,height: 30,),
                          Text("SERVINGS",style: TextStyle(fontSize: 9,color: Colors.grey),),
                          Text("2 people",style: TextStyle(fontSize: 9,color: Colors.black)),
                        ],
                      ),
                      Spacer(),
                      Column(
                        children: [
                          Image.network("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEoecVLOewI7w-TKdAVwN_YWg2k6o1ksqNf11ijwmP&s",width: 30,height: 30,),
                          Text("SERVINGS",style: TextStyle(fontSize: 9,color: Colors.grey),),
                          Text("2 people",style: TextStyle(fontSize: 9,color: Colors.black)),
                        ],
                      ),

                    ],
                  ),

                ),
              ),

              Container(
                width: double.infinity,
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(9)
                ),
                child: Column(
                  children: [
                    Padding(
                      padding: const EdgeInsets.only(right: 155.0,top: 10.0),
                      child: Text("INGREDIENTS ",style: TextStyle(fontSize:11),),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(11.0),
                      child: Text("flour Sugar Baking Powder"
                          "Loream ipsum dolor sit amet"
                          "Loream ipsum dolor sit amet"
                          "Loream ipsum dolor sit amet "),),],
                ),
              ),

              Center(child: Text("RELATED ITEMS YOU MAY LIKE",style: TextStyle(fontSize: 10.0,),)),

              Container(
                margin: EdgeInsets.only(top: 13),
                height:128.0,
                width: double.infinity,
                child: ListView.builder(
                  scrollDirection: Axis.horizontal,
                  physics: AlwaysScrollableScrollPhysics(),
                  itemCount: 10,
                  itemBuilder: (BuildContext context, int index) {

                    return  Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 6.0),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Container(
                            child: ClipRRect(
                              borderRadius: BorderRadius.circular(11),
                              child: Image.network("https://possible.in/wp-content/uploads/2016/01/04-2.jpg",width: 160,fit: BoxFit.cover),),
                          ),
                          Padding(
                            padding: const EdgeInsets.all(5.0),
                            child: Text("veg Sandwich"),
                          ),
                          Padding(
                            padding: const EdgeInsets.all(5.0),
                            child: Text("\$5.00"),
                          ),
                        ],
                      ),
                    );
                  },
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
