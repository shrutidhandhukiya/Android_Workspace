// To parse this JSON data, do
//
//     final getCartModel = getCartModelFromJson(jsonString);

import 'dart:convert';

GetCartModel getCartModelFromJson(String str) => GetCartModel.fromJson(json.decode(str));

String getCartModelToJson(GetCartModel data) => json.encode(data.toJson());

class GetCartModel {
  int success;
  List<dynamic> error;
  Data data;

  GetCartModel({
    required this.success,
    required this.error,
    required this.data,
  });

  factory GetCartModel.fromJson(Map<String, dynamic> json) => GetCartModel(
    success: json["success"],
    error: List<dynamic>.from(json["error"].map((x) => x)),
    data: Data.fromJson(json["data"]),
  );

  Map<String, dynamic> toJson() => {
    "success": success,
    "error": List<dynamic>.from(error.map((x) => x)),
    "data": data.toJson(),
  };
}

class Data {
  String weight;
  List<ProductCardItem> products;
  List<dynamic> vouchers;
  String couponStatus;
  String coupon;
  String voucherStatus;
  String voucher;
  bool rewardStatus;
  String reward;
  List<String> modules;
  List<dynamic> totals;
  String total;
  int totalRaw;
  int totalProductCount;
  int hasShipping;
  int hasDownload;
  Currency currency;

  Data({
    required this.weight,
    required this.products,
    required this.vouchers,
    required this.couponStatus,
    required this.coupon,
    required this.voucherStatus,
    required this.voucher,
    required this.rewardStatus,
    required this.reward,
    required this.modules,
    required this.totals,
    required this.total,
    required this.totalRaw,
    required this.totalProductCount,
    required this.hasShipping,
    required this.hasDownload,
    required this.currency,
  });

  factory Data.fromJson(Map<String, dynamic> json) => Data(
    weight: json["weight"],
    products: List<ProductCardItem>.from(json["products"].map((x) => ProductCardItem.fromJson(x))),
    vouchers: List<dynamic>.from(json["vouchers"].map((x) => x)),
    couponStatus: json["coupon_status"],
    coupon: json["coupon"],
    voucherStatus: json["voucher_status"],
    voucher: json["voucher"],
    rewardStatus: json["reward_status"],
    reward: json["reward"],
    modules: List<String>.from(json["modules"].map((x) => x)),
    totals: List<dynamic>.from(json["totals"].map((x) => x)),
    total: json["total"],
    totalRaw: json["total_raw"],
    totalProductCount: json["total_product_count"],
    hasShipping: json["has_shipping"],
    hasDownload: json["has_download"],
    currency: Currency.fromJson(json["currency"]),
  );

  Map<String, dynamic> toJson() => {
    "weight": weight,
    "products": List<dynamic>.from(products.map((x) => x.toJson())),
    "vouchers": List<dynamic>.from(vouchers.map((x) => x)),
    "coupon_status": couponStatus,
    "coupon": coupon,
    "voucher_status": voucherStatus,
    "voucher": voucher,
    "reward_status": rewardStatus,
    "reward": reward,
    "modules": List<dynamic>.from(modules.map((x) => x)),
    "totals": List<dynamic>.from(totals.map((x) => x)),
    "total": total,
    "total_raw": totalRaw,
    "total_product_count": totalProductCount,
    "has_shipping": hasShipping,
    "has_download": hasDownload,
    "currency": currency.toJson(),
  };
}

class Currency {
  int currencyId;
  String symbolLeft;
  String symbolRight;
  String decimalPlace;
  int value;

  Currency({
    required this.currencyId,
    required this.symbolLeft,
    required this.symbolRight,
    required this.decimalPlace,
    required this.value,
  });

  factory Currency.fromJson(Map<String, dynamic> json) => Currency(
    currencyId: json["currency_id"],
    symbolLeft: json["symbol_left"],
    symbolRight: json["symbol_right"],
    decimalPlace: json["decimal_place"],
    value: json["value"],
  );

  Map<String, dynamic> toJson() => {
    "currency_id": currencyId,
    "symbol_left": symbolLeft,
    "symbol_right": symbolRight,
    "decimal_place": decimalPlace,
    "value": value,
  };
}

class ProductCardItem {
  String key;
  String thumb;
  String name;
  int points;
  String productId;
  String model;
  List<dynamic> option;
  String quantity;
  String recurring;
  bool stock;
  String reward;
  String price;
  String total;
  int priceRaw;
  int totalRaw;

  ProductCardItem({
    required this.key,
    required this.thumb,
    required this.name,
    required this.points,
    required this.productId,
    required this.model,
    required this.option,
    required this.quantity,
    required this.recurring,
    required this.stock,
    required this.reward,
    required this.price,
    required this.total,
    required this.priceRaw,
    required this.totalRaw,
  });

  factory ProductCardItem.fromJson(Map<String, dynamic> json) => ProductCardItem(
    key: json["key"],
    thumb: json["thumb"],
    name: json["name"],
    points: json["points"],
    productId: json["product_id"],
    model: json["model"],
    option: List<dynamic>.from(json["option"].map((x) => x)),
    quantity: json["quantity"],
    recurring: json["recurring"],
    stock: json["stock"],
    reward: json["reward"],
    price: json["price"],
    total: json["total"],
    priceRaw: json["price_raw"],
    totalRaw: json["total_raw"],
  );

  Map<String, dynamic> toJson() => {
    "key": key,
    "thumb": thumb,
    "name": name,
    "points": points,
    "product_id": productId,
    "model": model,
    "option": List<dynamic>.from(option.map((x) => x)),
    "quantity": quantity,
    "recurring": recurring,
    "stock": stock,
    "reward": reward,
    "price": price,
    "total": total,
    "price_raw": priceRaw,
    "total_raw": totalRaw,
  };
}
