// To parse this JSON data, do
//
//     final productModel = productModelFromJson(jsonString);

import 'dart:convert';

ProductModel productModelFromJson(String str) => ProductModel.fromJson(json.decode(str));

String productModelToJson(ProductModel data) => json.encode(data.toJson());

class ProductModel {
  int success;
  List<dynamic> error;
  List<ProductDetail> data;

  ProductModel({
    required this.success,
    required this.error,
    required this.data,
  });

  factory ProductModel.fromJson(Map<String, dynamic> json) => ProductModel(
    success: json["success"],
    error: List<dynamic>.from(json["error"].map((x) => x)),
    data: List<ProductDetail>.from(json["data"].map((x) => ProductDetail.fromJson(x))),
  );

  Map<String, dynamic> toJson() => {
    "success": success,
    "error": List<dynamic>.from(error.map((x) => x)),
    "data": List<dynamic>.from(data.map((x) => x.toJson())),
  };
}

class ProductDetail {
  int id;
  int productId;
  String name;
  String? manufacturer;
  String sku;
  String model;
  String image;
  List<dynamic> images;
  String originalImage;
  List<dynamic> originalImages;
  String priceExcludingTax;
  String priceExcludingTaxFormated;
  String price;
  String priceFormated;
  int rating;
  String description;
  List<dynamic> attributeGroups;
  int special;
  int specialExcludingTax;
  String specialExcludingTaxFormated;
  String specialFormated;
  String specialStartDate;
  String specialEndDate;
  List<dynamic> discounts;
  List<dynamic> options;
  String minimum;
  String metaTitle;
  String metaDescription;
  String metaKeyword;
  String seoUrl;
  String tag;
  String upc;
  String ean;
  String jan;
  String isbn;
  String mpn;
  String location;
  dynamic stockStatus;
  int stockStatusId;
  int manufacturerId;
  int taxClassId;
  String dateAvailable;
  String weight;
  int weightClassId;
  String length;
  String width;
  String height;
  int lengthClassId;
  String subtract;
  String sortOrder;
  String status;
  DateTime dateAdded;
  String dateModified;
  String viewed;
  String weightClass;
  String lengthClass;
  String shipping;
  dynamic reward;
  String points;
  List<Category> category;
  int quantity;
  Reviews reviews;
  int? items=0;
  List<dynamic> recurrings;

  ProductDetail({
    required this.id,
    required this.productId,
    required this.name,
    required this.manufacturer,
    required this.sku,
    this.items=0,
    required this.model,
    required this.image,
    required this.images,
    required this.originalImage,
    required this.originalImages,
    required this.priceExcludingTax,
    required this.priceExcludingTaxFormated,
    required this.price,
    required this.priceFormated,
    required this.rating,
    required this.description,
    required this.attributeGroups,
    required this.special,
    required this.specialExcludingTax,
    required this.specialExcludingTaxFormated,
    required this.specialFormated,
    required this.specialStartDate,
    required this.specialEndDate,
    required this.discounts,
    required this.options,
    required this.minimum,
    required this.metaTitle,
    required this.metaDescription,
    required this.metaKeyword,
    required this.seoUrl,
    required this.tag,
    required this.upc,
    required this.ean,
    required this.jan,
    required this.isbn,
    required this.mpn,
    required this.location,
    required this.stockStatus,
    required this.stockStatusId,
    required this.manufacturerId,
    required this.taxClassId,
    required this.dateAvailable,
    required this.weight,
    required this.weightClassId,
    required this.length,
    required this.width,
    required this.height,
    required this.lengthClassId,
    required this.subtract,
    required this.sortOrder,
    required this.status,
    required this.dateAdded,
    required this.dateModified,
    required this.viewed,
    required this.weightClass,
    required this.lengthClass,
    required this.shipping,
    required this.reward,
    required this.points,
    required this.category,
    required this.quantity,
    required this.reviews,
    required this.recurrings,
  });

  factory ProductDetail.fromJson(Map<String, dynamic> json) => ProductDetail(
    id: json["id"],
    productId: json["product_id"],
    name: json["name"],
    manufacturer: json["manufacturer"],
    sku: json["sku"],
    model: json["model"],
    image: json["image"],
    images: List<dynamic>.from(json["images"].map((x) => x)),
    originalImage: json["original_image"],
    originalImages: List<dynamic>.from(json["original_images"].map((x) => x)),
    priceExcludingTax: json["price_excluding_tax"],
    priceExcludingTaxFormated: json["price_excluding_tax_formated"],
    price: json["price"],
    priceFormated: json["price_formated"],
    rating: json["rating"],
    description: json["description"],
    attributeGroups: List<dynamic>.from(json["attribute_groups"].map((x) => x)),
    special: json["special"],
    specialExcludingTax: json["special_excluding_tax"],
    specialExcludingTaxFormated: json["special_excluding_tax_formated"],
    specialFormated: json["special_formated"],
    specialStartDate: json["special_start_date"],
    specialEndDate: json["special_end_date"],
    discounts: List<dynamic>.from(json["discounts"].map((x) => x)),
    options: List<dynamic>.from(json["options"].map((x) => x)),
    minimum: json["minimum"],
    metaTitle: json["meta_title"],
    metaDescription: json["meta_description"],
    metaKeyword: json["meta_keyword"],
    seoUrl: json["seo_url"],
    tag: json["tag"],
    upc: json["upc"],
    ean: json["ean"],
    jan: json["jan"],
    isbn: json["isbn"],
    mpn: json["mpn"],
    location: json["location"],
    stockStatus: json["stock_status"],
    stockStatusId: json["stock_status_id"],
    manufacturerId: json["manufacturer_id"],
    taxClassId: json["tax_class_id"],
    dateAvailable: json["date_available"],
    weight: json["weight"],
    weightClassId: json["weight_class_id"],
    length: json["length"],
    width: json["width"],
    height: json["height"],
    lengthClassId: json["length_class_id"],
    subtract: json["subtract"],
    sortOrder: json["sort_order"],
    status: json["status"],
    dateAdded: DateTime.parse(json["date_added"]),
    dateModified: json["date_modified"],
    viewed: json["viewed"],
    weightClass: json["weight_class"],
    lengthClass: json["length_class"],
    shipping: json["shipping"],
    reward: json["reward"],
    points: json["points"],
    category: List<Category>.from(json["category"].map((x) => Category.fromJson(x))),
    quantity: json["quantity"],
    reviews: Reviews.fromJson(json["reviews"]),
    recurrings: List<dynamic>.from(json["recurrings"].map((x) => x)),
  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "product_id": productId,
    "name": name,
    "manufacturer": manufacturer,
    "sku": sku,
    "model": model,
    "image": image,
    "images": List<dynamic>.from(images.map((x) => x)),
    "original_image": originalImage,
    "original_images": List<dynamic>.from(originalImages.map((x) => x)),
    "price_excluding_tax": priceExcludingTax,
    "price_excluding_tax_formated": priceExcludingTaxFormated,
    "price": price,
    "price_formated": priceFormated,
    "rating": rating,
    "description": description,
    "attribute_groups": List<dynamic>.from(attributeGroups.map((x) => x)),
    "special": special,
    "special_excluding_tax": specialExcludingTax,
    "special_excluding_tax_formated": specialExcludingTaxFormated,
    "special_formated": specialFormated,
    "special_start_date": specialStartDate,
    "special_end_date": specialEndDate,
    "discounts": List<dynamic>.from(discounts.map((x) => x)),
    "options": List<dynamic>.from(options.map((x) => x)),
    "minimum": minimum,
    "meta_title": metaTitle,
    "meta_description": metaDescription,
    "meta_keyword": metaKeyword,
    "seo_url": seoUrl,
    "tag": tag,
    "upc": upc,
    "ean": ean,
    "jan": jan,
    "isbn": isbn,
    "mpn": mpn,
    "location": location,
    "stock_status": stockStatus,
    "stock_status_id": stockStatusId,
    "manufacturer_id": manufacturerId,
    "tax_class_id": taxClassId,
    "date_available": dateAvailable,
    "weight": weight,
    "weight_class_id": weightClassId,
    "length": length,
    "width": width,
    "height": height,
    "length_class_id": lengthClassId,
    "subtract": subtract,
    "sort_order": sortOrder,
    "status": status,
    "date_added": dateAdded.toIso8601String(),
    "date_modified": dateModified,
    "viewed": viewed,
    "weight_class": weightClass,
    "length_class": lengthClass,
    "shipping": shipping,
    "reward": reward,
    "points": points,
    "category": List<dynamic>.from(category.map((x) => x.toJson())),
    "quantity": quantity,
    "reviews": reviews.toJson(),
    "recurrings": List<dynamic>.from(recurrings.map((x) => x)),
  };
}

class Category {
  String name;
  int id;

  Category({
    required this.name,
    required this.id,
  });

  factory Category.fromJson(Map<String, dynamic> json) => Category(
    name: json["name"],
    id: json["id"],
  );

  Map<String, dynamic> toJson() => {
    "name": name,
    "id": id,
  };
}

class Reviews {
  int reviewTotal;

  Reviews({
    required this.reviewTotal,
  });

  factory Reviews.fromJson(Map<String, dynamic> json) => Reviews(
    reviewTotal: json["review_total"],
  );

  Map<String, dynamic> toJson() => {
    "review_total": reviewTotal,
  };
}
