
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_easyloading/flutter_easyloading.dart';
import 'package:orderdesing/model/GetCartModel.dart';
import 'package:orderdesing/model/ProductModel.dart';
import 'package:orderdesing/service/httpService.dart';
import '../Config/config.dart';
import '../Home.dart';
import '../Model/CategoriesModel.dart';
import '../model/SubCategoryModel.dart';


class CategoriesProvider extends ChangeNotifier{
  final service = httpService();
  bool isLoading = true;
  List<SubCategory>categories=[];
  int selectedCategory = 0;
  List<ProductDetail> products=[];
  GetCartModel? getCart;
  int total=0;

  CategoriesProvider(){
    getCategories();// api calling
    getToCartItems();
  }

  Future<void>getCategories() async{
    isLoading =true;
    notifyListeners();

    final response = await service.sendApiRequest(url: "api/rest/categories/", headers: {
    "Authorization" : "Bearer 6bf5256070d99ebf8bba56e2c413363b8455086e",
      // "Accept":"application/json"
    }, body: {}, method: "get");

    if(response!=null){
      var model=categoriesModelFromJson(response.body);
      //categories.addAll(model.data);
      var categoriesParent=model.data;

      for(var i in categoriesParent){
        final responseSubCategory = await service.sendApiRequest(url: "api/rest/categories/${i.categoryId}", headers: {
          "Authorization" : "Bearer 6bf5256070d99ebf8bba56e2c413363b8455086e",
          // "Accept":"application/json"
        }, body: {}, method: "get",context: navigationKey.currentContext);

        var modelSubCategpory = categoryDetailsModelFromJson(responseSubCategory!.body);
        categories.addAll(modelSubCategpory.data.subCategories);
      }
      print("List Response $categories");
      isLoading =false;
      notifyListeners();
    }
    isLoading =false;
    notifyListeners();

  }

  Future<void>getProducts(int category_id) async{
    isLoading =true;
    notifyListeners();

      var productresponse=await httpService().sendApiRequest(url: "api/rest/products/category/${category_id}/", headers: {
        "Authorization":"Bearer 6bf5256070d99ebf8bba56e2c413363b8455086e"
      }, body: {}, method: "get",context: navigationKey.currentContext );

      if(productresponse!.statusCode==200){
        var productModel=productModelFromJson(productresponse.body);

        /* List<ProductDetail> list=[];
        list.addAll(productModel.data);
        list.addAll(productModel.data);
        list.addAll(productModel.data);
        list.addAll(productModel.data);
        products.add(list);*/

        products.clear();
        products.addAll(productModel.data);
        changeProductQuality();
        //real one
      }
      isLoading =false;
      notifyListeners();
  }
    void addToCart({ ProductDetail? product, required BuildContext context, required String method,  ProductCardItem? productCard}) async {

   var response=await httpService().sendApiRequest(url:"api/rest/cart", headers: {
     "Authorization":"Bearer 6bf5256070d99ebf8bba56e2c413363b8455086e"
   }, body: {
     "product_id":"${product?.productId??productCard!.key}",
     "quantity":"${product?.sected??productCard!.quantity}",
     "key":"${product?.key??productCard!.key}"
   },
       //method ne dynamic call kro, and context parameter loaded mate used kru
       method: method,context: context);
       print("response of add/delete ${response}");
       getToCartItems();
       changeProductQuality();
  }

  Future<void>getToCartItems() async {
    var getResponse=await httpService().sendApiRequest(url:"api/rest/cart", headers: {
      "Authorization":"Bearer 6bf5256070d99ebf8bba56e2c413363b8455086e"
    }, body: {}, method: "get");

    if(getResponse!.statusCode==200){
      var getModel=getCartModelFromJson(getResponse.body);
      getCart=getModel;
      changeProductQuality;
    notifyListeners();
      print("response of GetCart: ${getResponse.body}");
    }
  }

  void changeProductQuality() {
    print("changeProductQuality");
    for(var i in getCart!.data.products){
      for(var j=0;j<products.length;j++){
        if(products[j].id.toString()==i.productId){
          logger.w("inside if");
          //fetch selected item from get card
          products[j].sected=int.parse(i.quantity);
          //fetch key for update record =>KEY is useful for update cart selected product qlt. pass in in post method while selected is not 0(delete) and 1(post)
          products[j].key=i.key;
          //update ui in screen
          notifyListeners();
        }
      }
    }
  }
}
