
import 'package:flutter/material.dart';
import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';

import 'OrderSystem.dart';

class OrderSystem extends StatefulWidget {
  @override

  State<StatefulWidget> createState() => OrderSystemState();

}

class OrderSystemState  extends State<OrderSystem>{
  final GlobalKey<ScaffoldState> key=GlobalKey();
  @override
  Widget build(BuildContext context)
  {
    return Scaffold(
      key: key,
        endDrawer: Drawer(
          child: DrawerWidget(),
      ),
        body: Container(
          padding: EdgeInsets.only(top: 5.0,bottom: 5.0),
          decoration: BoxDecoration(
            color: Colors.white,
              borderRadius: BorderRadius.circular(10)
          ),
          child: SingleChildScrollView(
            child: Column(
              //crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Container(
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(10)
                  ),
                  padding: EdgeInsets.only(left: 23.0,top: 0.0,bottom: 0.0),
                  child: Row(
                    children: [
                     Text.rich(
                       TextSpan(
                         text: "hunzerz".toUpperCase(),
                         style: TextStyle(color: Colors.grey,fontSize: 20),
                         children: [
                           TextSpan(
                             text: "desk".toUpperCase(),
                             style: TextStyle(color: Colors.yellow,fontSize: 20
                             )
                           )
                         ]
                       )
                     ),
                      Container(
                        margin: EdgeInsets.only(left: 159.0,top: 0.0,bottom: 0.0),
                          child: Icon(Icons.calendar_month,color: Colors.grey,size: 16,)),
                      Text("POS",style: TextStyle(color:Colors.grey,fontSize: 18,fontWeight: FontWeight.w800),),

                      Container(
                        padding: EdgeInsets.only(left: 33.0,),
                          child: Icon(Icons.traffic_sharp,color: Colors.grey,size: 16,)),
                      Text("Transaction",style: TextStyle(color:Colors.grey,fontSize: 18,fontWeight: FontWeight.w800),),

                      Container(
                          padding: EdgeInsets.only(left: 33.0),
                          child: Icon(Icons.card_travel,color: Colors.grey,size: 18)),
                      Text("Booking",style: TextStyle(color:Colors.grey,fontSize: 18,fontWeight: FontWeight.w800),),

                      Container(
                          padding: EdgeInsets.only(left: 33.0),
                          child: Icon(Icons.border_all,color: Colors.grey,size: 16)),
                      Text("Orders Status",style: TextStyle(color:Colors.grey,fontSize: 18  ,fontWeight: FontWeight.w800),),
                          Spacer(),

                     Container(
                       padding: EdgeInsets.only(right: 13.0,bottom: 4.0),
                       child: Stack(
                         children: [
                           Image.asset("assets/images/image.png",height: 80,width: 80,),
                           Positioned(
                             bottom: 0,right: 0,
                             child: CircleAvatar(
                               child: IconButton(onPressed: (){
                                 key.currentState!.openEndDrawer();
                               } , icon: Icon(Icons.menu)),
                             ),
                           ),
                         ],
                       ),
                     )
                      
                    ],
                  ),
                ),
                StaggeredGrid.count(
                    crossAxisCount: 5,
                    crossAxisSpacing: 0.5,
                    mainAxisSpacing: 2.0,
                  //childAspectRatio:2,
                    children: List.generate(order.length,(index) {
                      return Center(
                        child: OrderCard(order: order[index], key: Key(" "),),
                      );
                    })

                ),
              ],
            ),
          ),
        )
    );
  }

  DrawerWidget() {
    return ListView(
      children: [
        ListTile(
         leading: Icon(Icons.people),
          title: Text("People"),
        ),
        ListTile(
          leading: Icon(Icons.wallet),
          title: Text("Wallet"),
        ),
        ListTile(
          leading: Icon(Icons.food_bank),
          title: Text("Food Item"),
        ),
        ListTile(
          leading: Icon(Icons.reviews),
          title: Text("Reviews"),
        ),
        ListTile(
          leading: Icon(Icons.wallet),
          title: Text("Wallet"),
        ),
        ListTile(
          leading: Icon(Icons.settings),
          title: Text("Setting"),
        ),

        //Text("abd"),

      ],
    );
  }
}
class Order{
   Order({required this.name,required this.time,required this.orders,required this.color,required this.fields});
  final String name;
  final String time;
  final String orders;
  final Color color;
  List<String> fields=[];
}
 List<Order> order = [
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.red, fields: ["1 ChatMasala","Veg Cheese PizzaExtra Cheese","Fride Checken", "Mashroom Pizza"],),
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.orange, fields:  ["1 ChatMasala","Veg Cheese Pizza","Fride Checken", "Mashroom Pizza","Vanila IceCream","Egg Faritta","Mashroom Pizza","Mashroom Pizza"],),
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.red, fields: ["1 ChatMasala","Veg Cheese PizzaExtra Cheese","Fride Checken", "Mashroom Pizza","Fride Checken", "Mashroom Pizza"],),
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.red, fields:  ["1 ChatMasala","Veg Cheese Pizza","Fride Checken", "Mashroom Pizza","Vanila IceCream","Egg Faritta","Mashroom Pizza","Mashroom Pizza"],),
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.red, fields: ["1 ChatMasala","Veg Cheese PizzaExtra Cheese","Fride Checken", "Mashroom Pizza","Fride Checken", "Mashroom Pizza","Vanila IceCream",],),
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.green, fields: ["1 ChatMasala","Veg Cheese PizzaExtra Cheese","Fride Checken",],),
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.red, fields: ["1 ChatMasala","Veg Cheese PizzaExtra Cheese","Fride Checken",],),
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.red, fields: ["1 ChatMasala","Veg Cheese Pizza","Fride Checken", "Mashroom Pizza","Vanila IceCream","Egg Faritta","Mashroom Pizza","Mashroom Pizza"],),
   Order(name: "Dine-in", time: "08:49", orders:"AB00121", color: Colors.red, fields: ["1 ChatMasala","Veg Cheese Pizza","Fride Checken", "Mashroom Pizza","Vanila IceCream","Egg Faritta","Mashroom Pizza","Mashroom Pizza"],),


 ];

class OrderCard extends StatelessWidget {
  const OrderCard({required Key key, required this.order}):super(key: key);
  final Order order;

  @override
  Widget build(BuildContext context) {
    final TextStyle? textStyle = Theme.of(context).textTheme.displaySmall;

    return SizedBox(
      width: 270,
      child: Container(
        padding: EdgeInsets.only(left: 5.0,right:5.0,top: 5.0 ),
      // color: Colors.white,
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(10)
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
              //  margin: EdgeInsets.only(top: .0),
              padding: EdgeInsets.all(10),
              color: order.color,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      Text(
                        order.name,style: TextStyle(fontSize: 12,fontWeight: FontWeight.w800,color: Colors.white),
                      ),
                      Spacer(),

                      Container(
                        margin: EdgeInsets.only(top:10, ),
                        child: Text(
                          order.time,style: TextStyle(fontSize: 17,fontWeight: FontWeight.w800,color: Colors.white ),
                        ),
                      ),
                    ],
                  ),
                  Container(
                    margin: EdgeInsets.only(right: 11.0),
                    child: Text(order.orders,style: TextStyle(fontSize: 11,color: Colors.white),
                    ),
                  ),
                ],
              ),
            ),

           for(var i in order.fields)
             Container(
                 padding: EdgeInsets.only(left: 9.0 ,top: 19.0),
                 child: Text("1 ${i}",style: TextStyle(fontSize:16,color: Colors.grey),))
          ],
        ),
      ),
    );


  }
}