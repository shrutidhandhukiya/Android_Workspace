import 'package:flutter/material.dart';
import 'package:orderdesing/Home.dart';

class HungerzMenu extends StatefulWidget {

  @override
  State<HungerzMenu> createState() => _HungerzMenuState();
}

class _HungerzMenuState extends State<HungerzMenu> {

  @override
  Widget build(BuildContext context) {

    return Container(
      color: Colors.white,
      child: SafeArea(
        child: Scaffold(
            body: Column(
              children: [
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 12.0,vertical:20.0),
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
                    )
                  ],),
                ),
                Expanded(
                  child: GridView.count(
                      crossAxisCount: 4,
                      crossAxisSpacing: 0.5,
                      mainAxisSpacing: 13,
                      childAspectRatio:1.5,
                      children: List.generate(book.length,(index) {
                        return SelectCard(book: book[index],);
                      }
                      ),
                  ),
                 ),

             /*   SizedBox(
                  width:double.infinity,

                  child: ElevatedButton(

                    style: ButtonStyle(
                      backgroundColor: MaterialStatePropertyAll(Colors.white),
                    ),
                      onPressed: (){

                      }, child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                        children: [
                          Padding(padding: const EdgeInsets.only(left: 5.0,top: 26.0,bottom: 26.0),
                            child: Text("Devloped by:",style: TextStyle(color: Colors.orange,fontSize: 17,fontWeight: FontWeight.w300),),
                          ),

                              Padding(
                                padding: const EdgeInsets.only(left: 342.0),
                                child: Row(
                                  mainAxisAlignment: MainAxisAlignment.end,
                                  children: [
                                    Icon(Icons.ac_unit_sharp),
                                  ],
                                ),
                              ),
                              Text("OpusLobworks",style: TextStyle(fontSize: 23,fontWeight: FontWeight.w700,color: Colors.black),),
                            ],
                          )

                      ),
                  ),*/

              ],
            )

        ),
      ),
    );
  }
}

class BookingOrder{
  const BookingOrder({required this.name,required this.time,required this.orders,required this.color});
  final String name;
  final String time;
  final String orders;
  final Color color;
}

const List<BookingOrder> book  = const<BookingOrder>[
  const BookingOrder(name: 'Table 1', time: '1:33', orders: 'Served 4/5 items',color :Colors.green),
  const BookingOrder(name: 'Table 2', time: '1:33', orders: 'Served 2/3 items',color :Colors.orange),
  const BookingOrder(name: 'Table 3', time: '', orders: 'NO Order',color :Colors.white),
  const BookingOrder(name: 'Table 4', time: '1:33', orders: 'Served 2/6 items',color :Colors.green),
  const BookingOrder(name: 'Table 5', time: '1:33', orders: 'Served 2/5 items',color :Colors.green),
  const BookingOrder(name: 'Table 6', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 7', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 8', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 9', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 10', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 11', time: '1:33', orders: 'Served 2/5 items',color :Colors.green),
  const BookingOrder(name: 'Table 12', time: '1:33', orders: 'Served 2/5 items',color :Colors.orange),
  const BookingOrder(name: 'Table 13', time: '1:33', orders: 'Served 2/5 items',color :Colors.green),
  const BookingOrder(name: 'Table 14', time: '1:33', orders: 'Served 2/5 items',color :Colors.red),
  const BookingOrder(name: 'Table 15', time: '1:33', orders: 'No Order',color :Colors.green),
  const BookingOrder(name: 'Table 16', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 17', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 18', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 19', time: ' ', orders: 'No Order',color :Colors.white),
  const BookingOrder(name: 'Table 20', time: ' ', orders: 'No Order',color :Colors.white),



];

class SelectCard  extends StatelessWidget{
  const SelectCard({Key? key, required this.book }): super(key: key);
  final BookingOrder book;

  @override
  Widget build(BuildContext context) {
    final TextStyle?  textStyle = Theme.of(context).textTheme.displaySmall;
    return Container(
      padding: EdgeInsets.only(left: 10.0,right: 10.0,top: 5.0),
      child: ElevatedButton(
        style: ButtonStyle(
          backgroundColor: MaterialStatePropertyAll(book.color),
        ),
        onPressed: (){
          Navigator.push(context, MaterialPageRoute(builder: (_)=> Home()));
        },
        child: Column(
         crossAxisAlignment: CrossAxisAlignment.center,
         mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
             margin: EdgeInsets.only(top: 7),
              child: Row(
                children: [
                  Text(
                    book.name,style: TextStyle(overflow: TextOverflow.ellipsis, fontSize: 17, color: book.color==Colors.white?Colors.black:Colors.white,fontWeight: FontWeight.w800,),
                  ),
                  Spacer(),

                  Text(
                    book.time,style: TextStyle(overflow: TextOverflow.ellipsis, fontSize: 15, color:book.color==Colors.white?Colors.black:Colors.white,fontWeight: FontWeight.w800,),
                  ),
                ],
              ),
            ),
            Spacer(),

            Padding(
              padding: const EdgeInsets.only(bottom: 5.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  /*Padding(padding: const EdgeInsets.only(right: 78.0),
                    child:*/
                  Text(
                      book.orders,style: TextStyle( fontSize: 14,color: book.color==Colors.white?Colors.black:Colors.white),
                    ),
                //  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );


    /* return Card(
          color: Colors.yellow,
          margin: EdgeInsets.only(bottom: 33,top: 11,left: 11,right: 11),

          child:Column(
            children: [
              Row(
                children: [
                  Text(
                    book.name,style: TextStyle(overflow: TextOverflow.ellipsis, fontSize: 18, color: Colors.white,fontWeight: FontWeight.w800,),
                  ),
                  Spacer(),
                  Text(book.time,style: TextStyle(overflow: TextOverflow.ellipsis, fontSize: 18, color: Colors.white,fontWeight: FontWeight.w800),),
                ],
              ),
              Container(
              //    height: ,
               margin: EdgeInsets.only(top: 39),
                child: Text(book.orders,style:TextStyle(fontSize: 14)),
              ),
              // Text(book.time,style: TextStyle(overflow: TextOverflow.ellipsis, fontSize: 18, color: Colors.white,fontWeight: FontWeight.w800),),
             // Text(book.orders,style: textStyle,),
            ],
          )
      );*/
  }
}
