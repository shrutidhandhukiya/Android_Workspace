import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'dart:math' as math;
import 'package:flutter/material.dart';
import 'package:orderdesing/FinishOrder.dart';

class Home extends StatefulWidget {

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  final GlobalKey<ScaffoldState> key=GlobalKey();
  final GlobalKey<ScaffoldState> key1=GlobalKey();
  int select=0;
  int selected=0;
   List<Product> products = const <Product>[];
   List<Product> subProducts = const <Product>[];

   @override
  void initState() {
    // TODO: implement initState
    super.initState();
    products=[  Product(image: 'https://possible.in/wp-content/uploads/2016/01/04-2.jpg',title: 'Pizza',price: '\$300'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$300'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$300'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$300'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$300'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
       Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$500'),
    ];
    subProducts=[  Product(image: 'https://possible.in/wp-content/uploads/2016/01/04-2.jpg',title: 'Pizza',price: '\$300'),
      Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$300'),
      Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$300'),
      Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$300'),
      Product(image: 'https://cdn.pixabay.com/photo/2020/05/17/04/22/pizza-5179939_640.jpg',title: 'Pizza',price: '\$300'),
       ];
  }

  late ScrollController scrollController1 = ScrollController()
      ..addListener(() {
      double scrollOffset = scrollController1.offset;

      final double l1maxHeight = scrollController1.position.maxScrollExtent;
      final double l2maxHeight = scrollController2.position.maxScrollExtent;

      double jumpPoss = (math.min(l1maxHeight, l2maxHeight) * scrollOffset) /
          math.max(l1maxHeight, l2maxHeight);
      scrollController2.jumpTo((jumpPoss));
    });
  late ScrollController scrollController2 = ScrollController()
    ..addListener(() {
      double scrollOffset = scrollController1.offset;

      final double l1maxHeight = scrollController1.position.maxScrollExtent;
      final double l2maxHeight = scrollController2.position.maxScrollExtent;

      double jumpPoss = (math.min(l1maxHeight, l2maxHeight) * scrollOffset) /
          math.max(l1maxHeight, l2maxHeight);
      scrollController2.jumpTo((jumpPoss));
    });

  @override
  Widget build(BuildContext context) {
    return Container(
      child: SafeArea(
        child: Scaffold(
          key: key1,
          drawer: Drawer(
            child: Container(),),
          body: Scaffold(
            key: key,
            endDrawer: Drawer(
              child: DrawerWidget(),
            ),
            body: Column(
              children: [
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 15.0,vertical:4.0),
                  child: Row(
                    children: [
                      Text.rich(
                          TextSpan(
                            text:"hungerz".toUpperCase(),
                            style:TextStyle(color: Colors.black,fontSize: 23,fontWeight: FontWeight.w600),
                            children: [
                              TextSpan(
                                text: "e".toLowerCase(),
                                style:TextStyle(color: Colors.orange,fontSize: 23,fontWeight: FontWeight.w600),
                              ),
                              TextSpan(
                                text: "menu".toUpperCase(),
                                style:TextStyle(color: Colors.orange,fontSize: 23,fontWeight: FontWeight.w600),
                              )
                            ],
                          )
                      ),
                    Spacer(),

                      Expanded(
                    child: Padding(
                      padding: const EdgeInsets.only(left: 8.0,right: 12.0),
                      child: TextField(
                          decoration: InputDecoration(
                          hintText: "Serchview",
                          filled: true,fillColor: Colors.white30,
                          prefixIcon: Icon(Icons.search_rounded),
                          border: OutlineInputBorder(borderRadius: BorderRadius.all(Radius.circular(25.0))),
                        ),
                      ),
                    ),
                  ),
                      Padding(
                        padding: const EdgeInsets.symmetric(vertical: 5.0 ),
                        child: ElevatedButton(onPressed: (){
                          key.currentState!.openEndDrawer();
                          },
                          child: Text("items in Cart(0)",style: TextStyle(color: Colors.white),),

                          style: ElevatedButton.styleFrom(
                            primary: Colors.red,
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(21),
                              ),
                          ),
                        ),
                      )
                    ],),
                ),
                Expanded(
                  child: Row(
                    children: [

                      Container(
                        width: 100,
                        height:MediaQuery.of(context).size.height,
                        decoration: BoxDecoration(

                        ),
                        child: ClipRRect(
                          borderRadius: BorderRadius.only(bottomLeft: Radius.circular(8),bottomRight: Radius.circular(8)),

                          child: MaterialButton(
                            onPressed: (){},

                            child: ListView.builder(
                                itemCount: categorys.length, itemBuilder: (BuildContext context, int index){
                                  return GestureDetector(
                                    onTap: (){
                                      select=index;setState(() {
                                      });
                                    },
                                    child: Container(
                                      margin: EdgeInsets.all(10),
                                      decoration: BoxDecoration(
                                          color: select==index? Colors.orangeAccent:null,
                                          borderRadius: BorderRadius.circular(8)
                                      ),

                                      child: Container(
                                        margin: EdgeInsets.only(top: 10.0),
                                        child: Column(
                                          children: [
                                            Image.network(categorys[index].image,height: 50,width: 50,),
                                            Text(categorys[index].title,style: TextStyle(fontWeight: FontWeight.w500,fontSize: 11),)
                                          ],
                                        ),
                                      ),
                                    ),
                                  );}

                              ),


                             ),
                            ),
                          ),

                      Expanded(
                        child: ListView(
                          children: [
                           Container(
                             width:double.infinity,
                             height:MediaQuery.of(context).size.height/2,
                             child: ListView(
                               controller: scrollController1,
                               // physics: NeverScrollableScrollPhysics(),
                               scrollDirection: Axis.horizontal,
                               children:List.generate(products.length, (index) => ProductCard(product: products[index], context: context,set:this)),
                             ),
                           ),
                           Container(
                             width:double.infinity,
                             height:MediaQuery.of(context).size.height/2,
                             child: ListView(
                               controller: scrollController2,
                               // physics: NeverScrollableScrollPhysics(),
                               scrollDirection: Axis.horizontal,
                               children:List.generate(products.length, (index) => ProductCard(product: products[index], context: context,set:this)),

                             ),
                           ),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),),
        ),
      ),
    );
  }
  DrawerWidget(){
    return Column(
      children: [
        Expanded(
          child: SingleChildScrollView(
            child: Column(
              children: [
                ListTile(
                  title: Text("Table No 6"),
                ),

                LayoutWidgetOfsidebar(0),
                LayoutWidgetOfsidebar(1),
                LayoutWidgetOfsidebar(2),
                LayoutWidgetOfsidebar(3),

            ],
            ),
          ),
        ),
    SizedBox(
      width: double.infinity,
      child: ElevatedButton(onPressed: (){},
        style: ElevatedButton.styleFrom(
          primary: Colors.white
        ),
      child:
      Column(
        children: [
          Padding(
            padding: const EdgeInsets.only(top: 18.0,bottom: 18.0),
            child:
            Row(
              children: [
                Text("Total Amount",style: TextStyle(fontSize: 13,color: Colors.black),),
                Spacer(),
                Text("\$74.00",style: TextStyle(fontSize: 13,color: Colors.black),),
              ],
            ),
          ),
        ],
      ),

      ),
    ),

    SizedBox(
      width: double.infinity,
      child: ElevatedButton(onPressed: (){
        Navigator.push(context, MaterialPageRoute(builder: (_)=>FinishOrder()));

      }, child:
      Padding(
        padding: const EdgeInsets.only(bottom: 20.0,top: 20.0),
        child: Text("Finish Ordering",style: TextStyle(fontSize: 13,color: Colors.white),),
      ),
      ),
    ),],
    );
  }
LayoutWidgetOfsidebar(int index) {
    return  Padding(
      padding: const EdgeInsets.only(left: 8.0),
      child: Row(
        children: [
          Container(
            height: 50,
            width: 50,
            child: ClipRRect(
                borderRadius: BorderRadius.circular(8),
                child: Image.network("https://possible.in/wp-content/uploads/2016/01/04-2.jpg",fit: BoxFit.fill,)),
          ),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Padding(
                  padding: const EdgeInsets.only(left: 7.0),
                  child: Text("Veg Sandwich",style: TextStyle(fontSize: 10,color: Colors.black),),
                ),
                Padding(
                  padding: const EdgeInsets.only(top: 6.0,left: 8),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Container(
                        decoration: BoxDecoration(
                            border: Border.all(color: Colors.green),
                            borderRadius: BorderRadius.circular(18)
                        ),
                        child: Row(
                          children: [
                            GestureDetector(
                                onTap:(){
                                  setState(() {
                                    int? data=subProducts[index].sected??0;
                                    //conditionl = are used :else part run
                                    subProducts[index].sected==null?data=0:data==0?data=0:data--;
                                    subProducts[index].sected=data;
                                  });
                                },
                                child: Padding(
                                  padding: const EdgeInsets.only(left: 5.0,top: 3,bottom: 3),
                                  child: Icon(Icons.remove,color: Colors.green,size: 20,),
                                )),

                            Padding(
                              padding: const EdgeInsets.only(left: 3.0,right: 3.0),
                              child: Container(child: Text("${ subProducts[index].sected??0}"),),
                            ),
                            GestureDetector(
                              onTap: (){
                                setState(() {
                                  int? data=subProducts[index].sected??0;
                                  subProducts[index].sected==null?data=0:data++;

                                  subProducts[index].sected=data;
                                });
                              },

                                child: Padding(
                                  padding: const EdgeInsets.only(right: 5.0,top: 3,bottom: 3),
                                  child: Icon(Icons.add,color: Colors.green,size: 20),
                                )),],
                        ),
                      ),
                      Spacer(),

                      Padding(
                        padding: const EdgeInsets.only(right: 10.0,),
                        child: Text("\$5.00",style: TextStyle(fontSize:13,color: Colors.black)),),
                    ],),
                ),
                Padding(
                  padding: const EdgeInsets.only(top: 4.0,left: 7),
                  child: Text("Extra Cheese",style: TextStyle(fontSize:10),),
                ),],
            ),
          )
        ],
      ),
    ) ;
  }
  }

class Category{

  const Category({ required this.image,required this.title});

  final String image;
  final String title;
}

const List<Category> categorys = const<Category>[
  const Category(image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEoecVLOewI7w-TKdAVwN_YWg2k6o1ksqNf11ijwmP&s',title: 'Sendwich'),
  const Category(image:'https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg',title: 'Pizza'),
  const Category(image:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRc1Xl_Mq_pcyD58HaxDEytx-W5FhgAqyv70eZu3CRjjg&s',title: 'Shakes'),
  const Category(image:'https://static.vecteezy.com/system/resources/previews/008/386/570/original/asian-traditional-food-with-noodles-and-chopsticks-free-vector.jpg',title: 'Chinese'),
  const Category(image:'https://assets.epicurious.com/photos/5548e2316997a6ba1fd2abcb/4:3/w_1332,h_999,c_limit/56389478_vegetarian-spring-rolls_1x1.jpg',title: 'Rolls'),
  const Category(image:'https://t3.ftcdn.net/jpg/04/41/20/18/360_F_441201852_XQqp1wbAQj9udOC3iT7D0ahKgaf71bns.jpg',title: 'Biryani'),
  const Category(image:'https://media.gettyimages.com/id/165809123/vector/tasty-indian-cuisine-braed.jpg?s=612x612&w=gi&k=20&c=PTp_1Vmi4NyrNevlxEWSsP6KgdEQaU5eUnz8m9qQKkE=',title: 'North Indian'),
];

class Product{

   Product({required this.image,required this.title,required this.price, this.sected});
   final String image;
   final String title;
   final String price;
   int? sected;
}

ProductCard({ GlobalKey<ScaffoldState>? key,required Product product, required BuildContext context, required _HomeState set}){

  print(product.image);

  final TextStyle? textStyle = Theme.of(context).textTheme.displaySmall;

  return SizedBox(
    height: MediaQuery.of(context).size.height/2,
    child: MaterialButton(
        onPressed: (){
          product.sected==null?product!.sected=0:product.sected=null;
          set.setState(() {
          });
        },
      child: Stack(
        children: [
          Card(
            child: Center(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Expanded(
                    child: ClipRRect(
                        borderRadius: BorderRadius.only(topLeft: Radius.circular(10),topRight: Radius.circular(10)),
                        child: Image.network(product.image,width: (MediaQuery.of(context).size.height*60)/100,
                          errorBuilder: (_,__,___)
                        {
                          return Text("Image not Load");
                        },
                          fit: BoxFit.fill,),
                      ),
                  ),
                  Container(
                  margin: EdgeInsets.only(left: 8,top: 7),
                  child: Text(product.title, style: TextStyle(fontWeight: FontWeight.bold,fontSize: 13))),

                  Container(
                      margin: EdgeInsets.only(left: 8,top:5,bottom: 6),
                      child: Text(product.price, style: TextStyle(fontWeight: FontWeight.w700,fontSize: 12),textAlign: TextAlign.left,)),
                ],
              ),
            ),
          ),
          Positioned(
              right: 0,
              child: IconButton(onPressed: (){
                showGeneralDialog(
                  context: context,
                  barrierColor: Colors.black54,
                  barrierDismissible: true,
                  barrierLabel: 'Label',
                  pageBuilder: (_, __, ___) {
                    return Align(
                      alignment: Alignment.topRight,
                      child: Container(
                        color: Colors.blue,
                        width: 250,
                        height: MediaQuery.of(context).size.height,
                        child: SelectedItemDrawer(),
                      ),
                    );
                  },
                );
                // key!.currentState!.openEndDrawer();
                },
                icon: Icon(Icons.info),color: Colors.grey,),
          ),
          product.sected==null?Container():Positioned(
              bottom: 53,
              left:90,right: 90,
              child: Center(
                child: Row(
            children: [
                GestureDetector(
                    onTap: (){
                      set.setState(() {
                        int? data=product.sected??0;
                        product.sected==0?data=null:data--;
                        product.sected=data;
                      });
                    },
                    child: Padding(
                      padding: const EdgeInsets.only(right: 5.0),
                      child: Icon(Icons.remove,color: Colors.white,size: 20,),
                    )),

              CircleAvatar(
                  backgroundColor: Colors.red,
                  radius: 10,
                    child: Container(
                      child: Padding(
                        padding: const EdgeInsets.only(right: 5,left: 5),
                        child: Text("${product.sected??0}",style: TextStyle(color: Colors.white),),
                      ),)),

                GestureDetector(
                    onTap:(){
                      set.setState(() {
                        int? data=product.sected??0;
                        print(data);
                        product.sected==null?data=0:data++;
                        product.sected=data;
                      });
                    },
                    child: Padding(
                      padding: const EdgeInsets.only(left: 5.0),
                      child: Icon(Icons.add,color: Colors.white,size: 20,),
                    )),
            ],
          ),
              ))
        ],

      ),
    ),
  );
}

class SelectedItemDrawer extends StatefulWidget {
  @override
  State<StatefulWidget> createState() =>SelectedItemDrawerState();

}

class SelectedItemDrawerState extends State<SelectedItemDrawer> {
  bool valuefirst = false;
  bool valuesecond= false;
  bool valuethird=false;
  final GlobalKey<ScaffoldState> key1=GlobalKey();
  List<Product> products = const <Product>[];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Container(
          child: Column(
            children: [
              Padding(
                padding: const EdgeInsets.only(left: 129.0,top: 6),
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
                    child: Image.network("https://possible.in/wp-content/uploads/2016/01/04-2.jpg",)),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Padding(
                    padding: const EdgeInsets.only(left: 6.0),
                    child: Text("Cheese Bread",
                      style: TextStyle(fontSize: 13,color: Colors.black,fontWeight: FontWeight.w500),),
                  ),


                ],),
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
                        padding: const EdgeInsets.only(right:9.0,top: 4.0),
                        child: Text("\$12.00",style: TextStyle(fontSize: 9),),
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
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Checkbox(
                      value: this.valuefirst,
                      onChanged: (bool? value){
                        setState(() {
                          this.valuefirst=!valuefirst;
                          if(valuefirst=true){
                            valuesecond=false;
                            valuethird=false;
                          }
                        });


                      }), Text("Extra Cheese",style: TextStyle(fontSize: 12),),],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Checkbox(
                      value: this.valuesecond,
                      onChanged: (bool? value){
                        setState(() {
                          this.valuesecond=!valuesecond;
                          if(valuesecond=true){
                            valuefirst=false;
                            valuethird=false;
                          }
                        });

                      }), Text("Extra Cheese",style: TextStyle(fontSize: 12)),],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Checkbox(
                      value: this.valuethird,
                      onChanged: (bool? value){
                        setState(() {
                          this.valuethird=!valuethird;
                          if(valuethird=true){
                            valuefirst=false;
                            valuesecond=false;
                          }
                        });
                      }), Text("Extra Cheese",style: TextStyle(fontSize: 12)),],
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
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(9)
            ),
            child: Column(
              children: [
                Padding(
                  padding: const EdgeInsets.only(right: 155.0,top: 9.0),
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

              Text("RELATED ITEMS YOU MAY LIKE",style: TextStyle(fontSize: 10.0,),),

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

