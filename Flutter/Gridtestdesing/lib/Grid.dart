
import 'package:flutter/material.dart';
import 'package:gridtest/OrderSystem.dart';

class Grid extends StatefulWidget{

  @override
  State<StatefulWidget> createState()=>GridState();
}

class GridState extends State<Grid> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(" GridView"),
      ),
        body: GridView.count(
            crossAxisCount: 4,
            crossAxisSpacing: 0.5,
            mainAxisSpacing: 2.0,
            childAspectRatio:2,
            children: List.generate(book.length,(index) {
              return Center(
                child: SelectCard(book: book[index],),
              );

            }
            )
        )

    );
  }
}
class BookingOrder
{
  const BookingOrder({required this.name,required this.time,required this.orders,required this.color});
  final String name;
  final String time;
  final String orders;
  final Color color;
}
  const List<BookingOrder> book  = const<BookingOrder>[
    const BookingOrder(name: 'Table 1', time: '1:33', orders: 'ordered 5 item',color :Colors.green),
    const BookingOrder(name: 'Table 2', time: '1:33', orders: 'ordered 5 item',color :Colors.yellow),
    const BookingOrder(name: 'Table 3', time: '', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 4', time: '1:33', orders: 'ordered 5 item',color :Colors.green),
    const BookingOrder(name: 'Table 5', time: '1:33', orders: 'ordered 5 item',color :Colors.green),
    const BookingOrder(name: 'Table 6', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 7', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 8', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 9', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 10', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 11', time: '1:33', orders: 'ordered 5 item',color :Colors.green),
    const BookingOrder(name: 'Table 12', time: '1:33', orders: 'ordered 5 item',color :Colors.yellow),
    const BookingOrder(name: 'Table 13', time: '1:33', orders: 'ordered 5 item',color :Colors.green),
    const BookingOrder(name: 'Table 14', time: '1:33', orders: 'ordered 5 item',color :Colors.red),
    const BookingOrder(name: 'Table 15', time: '1:33', orders: 'ordered 5 item',color :Colors.green),
    const BookingOrder(name: 'Table 16', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 17', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 18', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 19', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 20', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 20', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 20', time: ' ', orders: 'ordered 5 item',color :Colors.white),
    const BookingOrder(name: 'Table 20', time: ' ', orders: 'ordered 5 item',color :Colors.white),


  ];

  class SelectCard  extends StatelessWidget{
    const SelectCard({Key? key, required this.book }): super(key: key);
    final BookingOrder book;

    @override
    Widget build(BuildContext context) {
      //  throw UnimplementedError();
        final TextStyle?  textStyle = Theme.of(context).textTheme.displaySmall;

        return MaterialButton(
          onPressed: (){
            Navigator.push(context, MaterialPageRoute(builder: (_)=> OrderSystem()));
            },
          child: Container(
            // height: 92,
            width: 259,
            margin: EdgeInsets.only( left: 8,right: 8,top: 5,bottom: 5,),
            // padding: EdgeInsets.only(top: 10,bottom: 10,right: 10,left: 10),
            decoration: BoxDecoration(
                color: book.color, borderRadius:
            BorderRadius.circular(7)

            ),
            child:Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  margin: EdgeInsets.only(left: 9.0,right: 10.0,top: 5.0,),
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
                Container(
                  margin: EdgeInsets.only(top: 25.0,right: 55.0,),
                  child:  Text(
                    book.orders,style: TextStyle( fontSize: 14,color: book.color==Colors.white?Colors.black:Colors.white),
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