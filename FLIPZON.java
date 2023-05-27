import java.util.*;
import java.lang.Math;
import java.util.Collections;
public class Assignment2 {
    public static void main(String[] args) {
        try {
            String admin = "akash";
            String password = "123";
            Scanner sc = new Scanner(System.in);
            ArrayList<Product> p1 = new ArrayList<>();
            ArrayList<Customer> C = new ArrayList<>();
            ArrayList<Deal> deal = new ArrayList<>();
            while (true) {
                System.out.println("WELCOME TO FLIPZON");
                String s = "1) Enter as Admin\n"
                        + "2) Explore the Product Catalog\n"
                        + "3) Show Available Deals\n"
                        + "4) Enter as Customer\n"
                        + "5) Exit the Application\n";
                System.out.println(s);
                int x = sc.nextInt();
                if (x == 1) {
                    System.out.println("Dear Admin, Please enter your username and password");
                    System.out.print("Name: ");
                    String name = sc.next();
                    sc.nextLine();
                    System.out.print("Password: ");
                    String pass = sc.next();
                    if (name.toLowerCase().compareTo(admin) == 0 && pass.compareTo(password) == 0) {
                        System.out.println("Welcome " + name + "!!!!");
                        while (true) {
                            System.out.println("Please choose any one of the following actions:");
                            String s1 = "1) Add category\n" +
                                    "2) Delete category\n" +
                                    "3) Add Product\n" +
                                    "4) Delete Product\n" +
                                    "5) Set Discount on Product\n" +
                                    "6) Add giveaway deal\n" +
                                    "7) Back\n";
                            System.out.println(s1);
                            int x1 = sc.nextInt();
                            if (x1 == 1) {
                                System.out.print("Add Category ID: ");
                                int id = sc.nextInt();
                                int c = 0;
                                for (Product p3 : p1) {
                                    if (p3.getCategory_id() == id) {
                                        c = 1;
                                        break;
                                    }
                                }
                                if (c == 1) {
                                    System.out.println("Dear Admin, the category ID is already used!!! Please set a different and a unique category ID");
                                } else {
                                    System.out.print("Add Name of Category: ");
                                    String category = sc.nextLine();
                                    category+=sc.nextLine();
                                    System.out.println("Add a Product:-");
                                    System.out.print("Product name: ");
                                    String p = sc.nextLine();
                                    System.out.print("Product ID: ");
                                    float pid = sc.nextFloat();
                                    System.out.print("Price(in RS): ");
                                    float price = sc.nextInt();
                                    System.out.print("Enter Quantity Available: ");
                                    int Q = sc.nextInt();
                                    System.out.print("Any other details: ");
                                    String details = sc.nextLine();
                                    details+=sc.nextLine();
                                    Admin A = new Admin();
                                    A.Add_category(id, category, p, pid, price, details, p1, Q);
                                }
                            }
                            if (x1 == 2) {
                                System.out.print("Name of Category: ");
                                String s2 = sc.nextLine();
                                s2+=sc.nextLine();
                                System.out.print("Category ID: ");
                                int Id = sc.nextInt();
                                Admin A = new Admin();
                                A.Delete_category(s2, Id, p1);
                            }
                            if (x1 == 3) {
                                System.out.print("Enter Category ID: ");
                                int id = sc.nextInt();
                                int k = 0;
                                int i = 0;
                                for (Product p3 : p1) {
                                    if (p3.getCategory_id() == id) {
                                        k = 1;
                                        break;
                                    }
                                    i++;
                                }
                                if (k != 1) {
                                    System.out.println("No such category of product exists, Please add that category first!!");
                                } else {
                                    System.out.println("Add a Product:-");
                                    System.out.print("Product name: ");
                                    String p = sc.next();
                                    sc.nextLine();
                                    System.out.print("Product ID: ");
                                    float pid = sc.nextFloat();
                                    int r = 0;
                                    for (Product p3 : p1) {
                                        if (p3.getProduct_id() == pid) {
                                            r = 1;
                                            break;
                                        }
                                    }
                                    if (r == 1) {
                                        System.out.println("Dear Admin, the product ID is already used!!! Please set a different and a unique product ID");
                                    }
                                    if (r == 0) {
                                        System.out.print("Price(in RS): ");
                                        float price = sc.nextInt();
                                        System.out.print("Enter Quantity Available: ");
                                        int Q = sc.nextInt();
                                        System.out.print("Any other details: ");
                                        String details = sc.nextLine();
                                        details+=sc.nextLine();
                                        Admin A = new Admin();
                                        A.Add_product(id, p1.get(i).getCategory_name(), p, pid, price, details, p1, Q);
                                    }
                                }

                            }
                            if (x1 == 4) {
                                System.out.print("Name of product: ");
                                String s2 = sc.nextLine();
                                s2+=sc.nextLine();
                                System.out.print("Product ID: ");
                                float Id = sc.nextFloat();
                                Admin A = new Admin();
                                A.Delete_product(s2, Id, p1);
                            }
                            if (x1 == 5) {
                                System.out.println("Dear Admin give the Product ID you want to add discount for");
                                float Id;
                                while (true) {
                                    System.out.print("Enter the Product ID: ");
                                    Id = sc.nextFloat();
                                    int j = 0;
                                    for (Product r : p1) {
                                        if (r.getProduct_id()==Id) {
                                            j = 1;
                                            break;
                                        }
                                    }
                                    if (j == 1) {
                                        break;
                                    } else {
                                        System.out.println("No such product exists!! Please enter a valid product ID");
                                    }
                                }
                                System.out.print("Discount for Elite Customers (in %): ");
                                float i1 = sc.nextFloat();
                                System.out.print("Discount for Normal Customers (in %): ");
                                float i2 = sc.nextFloat();
                                System.out.print("Discount for Prime Customers (in %): ");
                                float i3 = sc.nextFloat();
                                Admin A = new Admin();
                                A.setDiscount(p1, Id, i1, i2, i3);
                            }
                            if (x1 == 6) {
                                System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
                                float i1;
                                while (true) {
                                    System.out.print("Enter the first Product ID: ");
                                    i1 = sc.nextFloat();
                                    int j = 0;
                                    for (Product r : p1) {
                                        if (r.getProduct_id() == i1) {
                                            j = 1;
                                            break;
                                        }
                                    }
                                    if (j == 1) {
                                        break;
                                    } else {
                                        System.out.println("No such product exists!! Please enter a valid product ID");
                                    }
                                }
                                float i2;
                                while (true) {
                                    System.out.print("Enter the second Product ID: ");
                                    i2 = sc.nextFloat();
                                    int j = 0;
                                    for (Product r : p1) {
                                        if (r.getProduct_id() == i2) {
                                            j = 1;
                                            break;
                                        }
                                    }
                                    if (j == 1) {
                                        break;
                                    } else {
                                        System.out.println("No such product exists!! Please enter a valid product ID");
                                    }
                                }
                                int in1 = 0;
                                for (Product product1 : p1) {
                                    if (product1.getProduct_id() == i1) {
                                        break;
                                    }
                                    in1++;
                                }
                                int in2 = 0;
                                for (Product product2 : p1) {
                                    if (product2.getProduct_id() == i2) {
                                        break;
                                    }
                                    in2++;
                                }
                                float combined_price1;
                                float combined_price2;
                                float combined_price3;
                                while (true) {
                                    System.out.print("Enter the combined price(Should be less than their combined price) for Normal Customer: ");
                                    combined_price1 = sc.nextFloat();
                                    if (combined_price1 >= p1.get(in1).getPrice() + p1.get(in2).getPrice()) {
                                        System.out.println("Price of a deal should be less than combined price of individual products, Please enter valid price!!");
                                    } else {
                                        break;
                                    }
                                }
                                while (true) {
                                    System.out.print("Enter the combined price(Should be less than their combined price) for Elite Customer: ");
                                    combined_price2 = sc.nextFloat();
                                    if (combined_price2 >= p1.get(in1).getPrice() + p1.get(in2).getPrice()) {
                                        System.out.println("Price of a deal should be less than combined price of individual products, Please enter valid price!!");
                                    } else {
                                        break;
                                    }
                                }
                                while (true) {
                                    System.out.print("Enter the combined price(Should be less than their combined price) for Prime Customer: ");
                                    combined_price3 = sc.nextFloat();
                                    if (combined_price3 >= p1.get(in1).getPrice() + p1.get(in2).getPrice()) {
                                        System.out.println("Price of a deal should be less than combined price of individual products, Please enter valid price!!");
                                    } else {
                                        break;
                                    }
                                }
                                float did;
                                while(true){
                                    int o=0;
                                    System.out.print("Enter the Deal ID: ");
                                    did = sc.nextFloat();
                                    for (Deal d : deal){
                                        if(d.getDeal_id()==did){
                                            o=1;
                                            break;
                                        }
                                    }
                                    if(o==1){
                                        System.out.println("Deal already used!! Please enter a unique and different deal ID");
                                    }
                                    else{
                                        break;
                                    }
                                }
                                System.out.print("Enter the Quantity of Deal (Combo): ");
                                int a = sc.nextInt();
                                Admin A = new Admin();
                                A.Giveaway(p1, i1, i2, combined_price1, combined_price2, combined_price3, a, deal, did);
                            }
                            if (x1 == 7) {
                                break;
                            } else if (x1 > 7) {
                                System.out.println("Please Enter a valid input!!");
                            }
                        }
                    } else {
                        System.out.println("Invalid username or password!!");
                    }
                }
                if (x == 2) {
                    if (p1.size() == 0) {
                        System.out.println("No products available!!");
                    } else {
                        Customer c3 = new Customer();
                        c3.Explore_Product_Catalog(p1);
                    }
                }
                if (x == 3) {
                    if (deal.size() == 0) {
                        System.out.println("Dear User, there are no deals for now!!! Please check regularly for exciting deals.");
                    } else {
                        System.out.println("All available deals are:-");
                        int d1 = 1;
                        for (Deal d : deal) {
                            System.out.println("Deal " + d1 + " Contains:-");
                            System.out.println(1 + ")  Category: " + d.getP1().getCategory_name());
                            System.out.println("    Product name: " + d.getP1().getProduct_name());
                            System.out.println("    Product ID: " + d.getP1().getProduct_id());
                            System.out.println("    Price: Rs " + d.getP1().getPrice() + "/-");
                            System.out.println("    Quantity: " + 1);
                            System.out.println("    Details: " + d.getP1().getOther_details());
                            System.out.print("\n");

                            System.out.println(2 + ")  Category: " + d.getP2().getCategory_name());
                            System.out.println("    Product name: " + d.getP2().getProduct_name());
                            System.out.println("    Product ID: " + d.getP2().getProduct_id());
                            System.out.println("    Price: Rs " + d.getP2().getPrice() + "/-");
                            System.out.println("    Quantity: " + 1);
                            System.out.println("    Details: " + d.getP2().getOther_details());
                            System.out.print("\n");

                            System.out.println("Deal Price for ELITE customers: " + d.getPrice_elite());
                            System.out.println("Deal Price for NORMAL customers: " + d.getPrice_normal());
                            System.out.println("Deal Price for PRIME customers: " + d.getPrice_prime());
                            System.out.println("Deal ID: " + d.getDeal_id());
                            System.out.println("Deal Quantity: " + d.getQuantity());
                            System.out.print("\n");
                            d1++;
                        }
                    }
                }
                if (x == 4) {
                    while (true) {
                        System.out.println("1) Sign up");
                        System.out.println("2) Log in");
                        System.out.println("3) Back");
                        int x2 = sc.nextInt();
                        if (x2 == 1) {
                            System.out.print("Enter name: ");
                            String name = sc.nextLine();
                            name+=sc.nextLine();
                            System.out.print("Enter password: ");
                            String pass = sc.next();
                            sc.nextLine();
                            Customer c = new Customer();
                            c.setName(name);
                            c.setPassword(pass);
                            C.add(c);
                            System.out.println("Customer successfully registered!!");
                        } else if (x2 == 2) {
                            System.out.print("Enter name: ");
                            String n = sc.nextLine();
                            n+=sc.nextLine();
                            System.out.print("Enter password: ");
                            String p = sc.next();
                            sc.nextLine();
                            int v = 0;
                            for (Customer c1 : C) {
                                if (c1.getName().compareTo(n) == 0 && c1.getPassword().compareTo(p) == 0) {
                                    break;
                                }
                                v++;
                            }
                            if (v == C.size()) {
                                System.out.println("Invalid username or password!!");
                            } else {
                                while (true) {
                                    System.out.println("Welcome " + C.get(v).getName() + "!!");
                                    String s1 = "1) browse products\n" +
                                            "2) browse deals\n" +
                                            "3) add a product to cart\n" +
                                            "4) add products in deal to cart\n" +
                                            "5) view coupons\n" +
                                            "6) check account balance\n" +
                                            "7) view cart\n" +
                                            "8) empty cart\n" +
                                            "9) checkout cart\n" +
                                            "10) upgrade customer status\n" +
                                            "11) Add amount to wallet\n" +
                                            "12) back\n";
                                    System.out.println(s1);
                                    int n1 = sc.nextInt();
                                    if (n1 == 1) {
                                        if (p1.size() == 0) {
                                            System.out.println("No products available for now!!");
                                        } else {
                                            System.out.println("All available products are as follows:-");
                                            int y = 1;
                                            for (Product P : p1) {
                                                System.out.println(y + ")  Category: " + P.getCategory_name());
                                                System.out.println("    Product name: " + P.getProduct_name());
                                                System.out.println("    Product ID: " + P.getProduct_id());
                                                System.out.println("    Price: Rs " + P.getPrice() + "/-");
                                                System.out.println("    Quantity: " + P.getAvailable());
                                                System.out.println("    Details: " + P.getOther_details());
                                                System.out.print("\n");
                                                y++;
                                            }
                                        }
                                    } else if (n1 == 2) {
                                        if (deal.size() == 0) {
                                            System.out.println("Dear User, there are no deals for now!!! Please check regularly for exciting deals.!!");
                                        } else {
                                            System.out.println("Available Deals:-");
                                            int d1 = 1;
                                            for (Deal d : deal) {
                                                System.out.println("Deal " + d1 + " Contains:-");
                                                System.out.println(1 + ")  Category: " + d.getP1().getCategory_name());
                                                System.out.println("    Product name: " + d.getP1().getProduct_name());
                                                System.out.println("    Product ID: " + d.getP1().getProduct_id());
                                                //System.out.println("    Price: Rs " + d.getP1().getPrice() +"/-");
                                                System.out.println("    Quantity: " + 1);
                                                System.out.println("    Details: " + d.getP1().getOther_details());
                                                System.out.print("\n");

                                                System.out.println(2 + ")  Category: " + d.getP2().getCategory_name());
                                                System.out.println("    Product name: " + d.getP2().getProduct_name());
                                                System.out.println("    Product ID: " + d.getP2().getProduct_id());
                                                //System.out.println("    Price: Rs " + d.getP2().getPrice() +"/-");
                                                System.out.println("    Quantity: " + 1);
                                                System.out.println("    Details: " + d.getP2().getOther_details());
                                                System.out.print("\n");
                                                if (C.get(v).getStatus() == 0) {
                                                    System.out.println("Deal Price: " + d.getPrice_elite());
                                                } else if (C.get(v).getStatus() == 1) {
                                                    System.out.println("Deal Price: " + d.getPrice_normal());
                                                } else if (C.get(v).getStatus() == 2) {
                                                    System.out.println("Deal Price: " + d.getPrice_prime());
                                                }
                                                System.out.println("Deal Id: " + d.getDeal_id());
                                                System.out.println("Deal Quantity: " + d.getQuantity());
                                                System.out.print("\n");
                                                d1++;
                                            }
                                        }
                                    } else if (n1 == 3) {
                                        System.out.print("Enter Product ID: ");
                                        float y = sc.nextFloat();
                                        System.out.print("Enter Quantity: ");
                                        int q = sc.nextInt();
                                        int k1=0;
                                        for (Product P3 : C.get(v).Cart){
                                            if (P3.getProduct_id()==y){
                                                k1=1;
                                                break;
                                            }
                                        }
                                        if(k1==1){
                                            for (Product P4 : C.get(v).Cart){
                                                if(P4.getProduct_id()==y){
                                                    P4.setQuantity(P4.getQuantity()+q);
                                                    System.out.println("Quantity of already present product in the cart is updated!!");
                                                    break;
                                                }
                                            }
                                        }
                                        if(k1==0){
                                        Customer c1 = new Customer();
                                        c1.Add_to_cart(y, q, p1, C.get(v));}
                                    } else if (n1 == 4) {
                                        System.out.print("Enter the Deal ID: ");
                                        float Id = sc.nextFloat();
                                        System.out.print("Enter the Deal Quantity: ");
                                        int D_quantity = sc.nextInt();
                                        int k1 = 0;
                                        for (Deal P3 : C.get(v).Deal_Cart) {
                                            if (P3.getDeal_id() == Id) {
                                                k1 = 1;
                                                break;
                                            }
                                        }
                                        System.out.println(k1);
                                        if (k1 == 1) {
                                            for (Deal P4 : C.get(v).Deal_Cart) {
                                                if (P4.getDeal_id() == Id) {
                                                    P4.setBy_quantity(P4.getBy_quantity() + D_quantity);
                                                    System.out.println("Quantity of already present Deal in the cart is updated!!");
                                                    break;
                                                }
                                            }
                                        }
                                        if (k1 == 0) {


                                            int f = 1;
                                            for (Deal d1 : deal) {
                                                if (d1.getDeal_id() == Id) {
                                                    if (d1.getQuantity() < D_quantity) {
                                                        System.out.println("That much quantity is not available!!");
                                                        break;
                                                    } else if (d1.getQuantity() == 0) {
                                                        System.out.println("Deal out of Stock!!");
                                                        break;
                                                    } else {
                                                        d1.setBy_quantity(D_quantity);
                                                        C.get(v).Deal_Cart.add(d1);
                                                        f = 0;
                                                        System.out.println("Deal item successfully added to the cart!!");
                                                        break;
                                                    }
                                                }
                                            }
                                            if (f == 1) {
                                                System.out.println("No such deal is available");
                                            }
                                        }
                                    }else if (n1 == 5) {
                                        if (C.get(v).coupon_values.size() == 0) {
                                            System.out.println("No coupons available!!");
                                        } else {
                                            System.out.println("Available coupons are:-");
                                            for (int j : C.get(v).coupon_values) {
                                                System.out.println("Coupon with " + j + "% discount");
                                            }
                                        }
                                    } else if (n1 == 6) {
                                        System.out.println("Current account balance is Rupees " + C.get(v).getBalance());
                                    } else if (n1 == 7) {
                                        if (C.get(v).Cart.size() == 0 && C.get(v).Deal_Cart.size() == 0) {
                                            System.out.println("Cart is empty!! please add items");
                                        } else {
                                            if (C.get(v).Cart.size() != 0) {
                                                System.out.println("Available Products in Cart are as follows:-");
                                                int u = 1;
                                                for (Product p5 : C.get(v).Cart) {
                                                    System.out.println(u + ")  Category: " + p5.getCategory_name());
                                                    System.out.println("    Product name: " + p5.getProduct_name());
                                                    System.out.println("    Product ID: " + p5.getProduct_id());
                                                    System.out.println("    Price: Rs " + p5.getPrice() + "/-");
                                                    System.out.println("    Quantity: " + p5.getQuantity());
                                                    System.out.println("    Details: " + p5.getOther_details());
                                                    System.out.print("\n");
                                                    u++;
                                                }
                                            }
                                            if (C.get(v).Deal_Cart.size() != 0) {
                                                System.out.println("Available Deals in Cart are as follows:-");
                                                int d1 = 1;
                                                for (Deal d : C.get(v).Deal_Cart) {
                                                    System.out.println("Deal " + d1 + " Contains:-");
                                                    System.out.println(1 + ")  Category: " + d.getP1().getCategory_name());
                                                    System.out.println("    Product name: " + d.getP1().getProduct_name());
                                                    System.out.println("    Product ID: " + d.getP1().getProduct_id());
                                                    System.out.println("    Price: Rs " + d.getP1().getPrice() + "/-");
                                                    System.out.println("    Quantity: " + 1);
                                                    System.out.println("    Details: " + d.getP1().getOther_details());
                                                    System.out.print("\n");

                                                    System.out.println(2 + ")  Category: " + d.getP2().getCategory_name());
                                                    System.out.println("    Product name: " + d.getP2().getProduct_name());
                                                    System.out.println("    Product ID: " + d.getP2().getProduct_id());
                                                    System.out.println("    Price: Rs " + d.getP2().getPrice() + "/-");
                                                    System.out.println("    Quantity: " + 1);
                                                    System.out.println("    Details: " + d.getP2().getOther_details());
                                                    System.out.print("\n");
                                                    d1++;
                                                    if (C.get(v).getStatus() == 0) {
                                                        System.out.println("Deal Price: " + d.getPrice_elite());
                                                    } else if (C.get(v).getStatus() == 1) {
                                                        System.out.println("Deal Price: " + d.getPrice_normal());
                                                    } else if (C.get(v).getStatus() == 2) {
                                                        System.out.println("Deal Price: " + d.getPrice_prime());
                                                    }
                                                    System.out.println("Deal Id: " + d.getDeal_id());
                                                    System.out.println("Deal Quantity: " + d.getBy_quantity());
                                                    System.out.print("\n");
                                                }

                                            }
                                        }
                                    } else if (n1 == 8) {
                                        C.get(v).Cart.clear();
                                        System.out.println("Cart Emptied Successfully!!");
                                    } else if (n1 == 9) {
                                        if (C.get(v).Cart.size() == 0 && C.get(v).Deal_Cart.size() == 0) {
                                            System.out.println("Cart is empty!! please add items");
                                        } else {
                                            Customer c2 = new Customer();
                                            c2.Make_payment(C.get(v), p1);
                                        }
                                    } else if (n1 == 10) {
                                        System.out.println("An “ELITE” membership costs Rs 300 and a “PRIME membership costs Rs 200.");
                                        if (C.get(v).getStatus() == 0) {
                                            System.out.println("Current Status: ELITE");
                                        } else if (C.get(v).getStatus() == 1) {
                                            System.out.println("Current Status: NORMAL");
                                        } else if (C.get(v).getStatus() == 2) {
                                            System.out.println("Current Status: PRIME");
                                        }
                                        System.out.print("Choose new status (ELITE/PRIME): ");
                                        String st = sc.next();
                                        String st1 = st.toLowerCase();
                                        Customer c = new Customer();
                                        c.upgrade_status(C.get(v), st1);
                                    } else if (n1 == 11) {
                                        System.out.print("Enter amount to be added: ");
                                        float a = sc.nextFloat();
                                        float e = C.get(v).getBalance();
                                        e += a;
                                        C.get(v).setBalance(e);
                                        System.out.println("Amount added successfully!!");
                                    } else if (n1 == 12) {
                                        System.out.println("Bye " + C.get(v).getName() + "!!");
                                        break;
                                    } else if (n1 > 12) {
                                        System.out.println("Please Enter a valid input!!");
                                    }
                                }
                            }

                        } else if (x2 == 3) {
                            break;
                        } else if (x2 > 3) {
                            System.out.println("Please Enter a valid input!!");
                        }
                    }
                }
                if (x == 5) {
                    System.out.println("Thanks for using FLIPZON!!!");
                    break;
                }
                if (x > 5) {
                    System.out.println("Please Enter a valid input!!");
                }
            }
            sc.close();
        }
        catch (Exception e){
            System.out.println("Something Went wrong, Please rerun the program.");
        }
    }
}
interface admin{

    void Add_category(int l1, String l2, String l3, float l4, float l5, String l6, ArrayList<Product> L, int f);

    void Add_product(int l1, String l2, String l3, float l4, float l5, String l6, ArrayList<Product> L, int g);

    void Delete_category(String K, int L, ArrayList<Product> P);

    void Delete_product(String K, float L, ArrayList<Product> P);

    void setDiscount(ArrayList<Product> list, float Id, float x1, float x2, float x3);
    void Giveaway(ArrayList<Product> p1, float i1, float i2, float combined_price1, float combined_price2, float combined_price3, int a, ArrayList<Deal> deal, float x);
}
class Admin implements admin{
    String name;
    int roll_no;

    @Override
    public void Add_category(int l1, String l2, String l3, float l4, float l5, String l6, ArrayList<Product> L,int f) {
        Product P = new Product(l1,l2,l3,l4,l5,l6,f);
        L.add(P);
    }
    @Override
    public void Add_product(int l1, String l2, String l3, float l4, float l5, String l6, ArrayList<Product> L, int g) {
        Product P = new Product(l1,l2,l3,l4,l5,l6,g);
        L.add(P);
    }
    @Override
    public void Delete_category(String K, int L, ArrayList<Product> P){
        int k=0;
        for (int i=0; i<P.size(); i++){
            if(P.get(i).getCategory_name().compareTo(K)==0 && P.get(i).getCategory_id()==L){
                k=1;
                P.remove(P.get(i));
            }
        }
        if(k==0){
            System.out.println("No such category found!!");
        }
        if(k==1){
            System.out.println("Category Deleted successfully!!");
        }
    }
    @Override
    public void Delete_product(String K, float L, ArrayList<Product> P) {
        int k=0;
        for (int i=0; i<P.size(); i++){
            if(P.get(i).getProduct_name().compareTo(K)==0 && P.get(i).getProduct_id()==L){
                k=1;
                P.remove(P.get(i));
                System.out.println("Product Deleted successfully!!");
                break;
            }
        }
        if(k==0){
            System.out.println("No such product found!!");
        }
    }
    @Override
    public void setDiscount(ArrayList<Product> list, float Id, float x1, float x2, float x3) {
        for (Product p4 : list){
            if(p4.getProduct_id() ==Id){
                p4.setElite_discount(x1);
                p4.setNormal_discount(x2);
                p4.setPrime_discount(x3);
            }
        }
    }
    @Override
    public void Giveaway(ArrayList<Product> p1, float i1, float i2, float combined_price1, float combined_price2, float combined_price3, int a, ArrayList<Deal> deal, float x) {
        int in1=0;
        for (Product product1 :p1){
            if(product1.getProduct_id() ==i1){
                break;
            }
            in1++;
        }
        int in2=0;
        for (Product product2 :p1){
            if(product2.getProduct_id() ==i2){
                break;
            }
            in2++;
        }
        Deal new_deal = new Deal(p1.get(in1),p1.get(in2));
        new_deal.setDeal_id(x);
        new_deal.setPrice_normal(combined_price1);
        new_deal.setPrice_elite(combined_price2);
        new_deal.setPrice_prime(combined_price3);
        new_deal.setQuantity(a);
        int g1 = new_deal.getP1().getQuantity();
        g1-=1;
        new_deal.getP1().setQuantity(g1);
        int g2 = new_deal.getP2().getQuantity();
        g2-=1;
        new_deal.getP2().setQuantity(g2);
        deal.add(new_deal);
    }
}
interface customer{
    void upgrade_status(Customer p, String s);
    void Explore_Product_Catalog(ArrayList<Product> E);

    void Add_to_cart(float z, int q, ArrayList<Product> L, Customer C);

    void Make_payment(Customer C,ArrayList<Product> P2);
}

class Customer implements customer{
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    private String name;

    int age;
    long phone_number;
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private float balance = 1000;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status=1;
    ArrayList<Product> Cart = new ArrayList<>();
    ArrayList<Deal> Deal_Cart = new ArrayList<>();
    ArrayList<Integer> coupon_values = new ArrayList<>();


    @Override
    public void upgrade_status(Customer p, String s) {
        if(s.compareTo("elite")==0){
            p.balance-=300;
            p.status=0;
            System.out.println("Status updated to ELITE");
        }
        else if (s.compareTo("normal")==0) {
            p.status=1;
        }
        else if (s.compareTo("prime")==0) {
            p.balance-=200;
            p.status=2;
            System.out.println("Status updated to PRIME");
        }
        ;
    }

    @Override
    public void Explore_Product_Catalog(ArrayList<Product> E) {
        System.out.println("All available products are as follows:-");
        int y=1;
        for (Product P : E){
            System.out.println(y+")  Category: "+ P.getCategory_name());
            System.out.println("    Product name: "+ P.getProduct_name());
            System.out.println("    Product ID: "+ P.getProduct_id());
            System.out.println("    Price: Rs " + P.getPrice() +"/-");
            System.out.println("    Quantity: "+ P.getAvailable());
            System.out.println("    Details: "+ P.getOther_details());
            System.out.print("\n");
            y++;
        }
    }

    @Override
    public void Add_to_cart(float z, int q, ArrayList<Product> L, Customer C) {
        for (Product p6: L){
            if(p6.getProduct_id() ==z){
                if(p6.getAvailable() ==0){
                    System.out.println("Product out of Stock!!");
                    break;
                }
                else if(q> p6.getAvailable()){
                    System.out.println("That much quantity is not available!!");
                    break;
                }
                p6.setQuantity(q);
                C.Cart.add(p6);
                System.out.println("Product added successfully to the cart!!");
                break;
            }
        }

    }

    @Override
    public void Make_payment(Customer C, ArrayList<Product> P2) {
        int l1 = 1;
        int l2 = 10;
        int a1 = (int) (Math.random()*(l2-l1+1)+l1);
        float total=0;
        float x=0;
        float z=0;
        float m=0;
        if(C.Cart.size()!=0) {
            for (Product t : C.Cart) {
                if(t.getAvailable()<t.getQuantity()){
                    System.out.println("Product with name:" + t.getProduct_name()+" is not available in that much Quantity which you have added in your cart!! Please Clear and Re-fill your cart.");
                    return;
                }
                z += t.getPrice() * t.getQuantity();
                if (C.coupon_values.size() > 0) {
                    Collections.sort(C.coupon_values);
                    m += C.coupon_values.get(C.coupon_values.size() - 1);
                }
                if (C.status == 0) {
                    if (t.getElite_discount() > 10 && t.getElite_discount() > m) {
                        x += (t.getPrice() - (t.getElite_discount() / 100) * (t.getPrice())) * t.getQuantity();
                    } else if (t.getElite_discount() < 10 && m < 10) {
                        x += (0.9 * t.getPrice()) * t.getQuantity();
                    } else {
                        x += (t.getPrice() * (1 - (m / 100))) * t.getQuantity();
                    }
                } else if (C.status == 1) {
                    x += (t.getPrice() - (t.getNormal_discount() / 100) * (t.getPrice())) * t.getQuantity();
                } else if (C.status == 2) {
                    if (t.getPrime_discount() >= 5 && t.getPrime_discount() >= m) {
                        x += (t.getPrice() - (t.getPrime_discount() / 100) * (t.getPrice())) * t.getQuantity();
                    } else if (t.getPrime_discount() <= 5 && m <= 5) {
                        x += (0.95 * t.getPrice()) * t.getQuantity();
                    } else {
                        x += (t.getPrice() * (1 - (m / 100))) * t.getQuantity();
                    }
                }

            }
        }
        total+=x;
        float b = total;
        float charges = 100;
        float deal_cost = 0;
        if(C.Deal_Cart.size()!=0){
            for (Deal d2 : C.Deal_Cart){
                if(d2.getQuantity()<d2.getBy_quantity()){
                    System.out.println("Deal with ID: "+d2.getDeal_id()+ "is not available in that much Quantity which you have added in the cart!! Please CLear and Re-fill your cart.");
                    return;
                }
                if(C.status==0){
                    deal_cost+= d2.getPrice_elite()*d2.getBy_quantity();
                }
                else if(C.status==1){
                    deal_cost+= d2.getPrice_normal()*d2.getBy_quantity();
                }
                else if(C.status==2){
                    deal_cost+= d2.getPrice_normal()*d2.getBy_quantity();
                }
            }

        }
        if(C.status==1){
            charges+=(z+deal_cost)/20;
        }
        else if(C.status==2){
            charges+=(z+deal_cost)/50;
        }
        float cost = charges+total;
        float total_cost = cost + deal_cost;
        if(C.balance<total_cost){
            System.out.println("Insufficient balance!! Please try again");
        }
        else if(C.balance>total_cost){
            System.out.println("Your order is placed successfully!!");
            if(C.Cart.size()!=0){
            System.out.println("Details of products:-");
            int t=1;
            for (Product p5 :C.Cart) {
                System.out.println(t + ")  Product name: " + p5.getProduct_name());
                System.out.println("    Product ID: " + p5.getProduct_id());
                System.out.println("    Details: " + p5.getOther_details());
                System.out.printf("    Price: Rs. %.2f %s\n", p5.getPrice(), "/-");
                System.out.println("    Quantity: " + p5.getQuantity());
                System.out.print("\n");
                int av = p5.getAvailable();
                av -= p5.getQuantity();
                p5.setAvailable(av);
                t++;
            }
            if(a1>7 && C.status==0){
                System.out.println("Congratulations!! You won a Free Product from FLIPZON.");
                System.out.println("Free product details:-");
                System.out.println("Product name: " + P2.get(P2.size()-1).getProduct_name());
                System.out.println("Product ID: " + P2.get(P2.size()-1).getProduct_id());
                System.out.println("Details: " + P2.get(P2.size()-1).getOther_details());
                System.out.println("Quantity: 1");
            }
                if(C.Cart.size()!=0) {
                    for (Product t1 : C.Cart) {
                        if (C.status == 0) {
                            if (t1.getElite_discount() > 10 && t1.getElite_discount() > m) {
                                System.out.printf("Congratulations!! Discount: %.1f percent of %.2f = %.2f\n", t1.getElite_discount(), z, (z * t1.getElite_discount()) / 100);
                            } else if (t1.getElite_discount() < 10 && m < 10) {
                                System.out.printf("Congratulations!! Discount: 10 percent of %.2f = %.2f\n", z, z / 10);
                            } else {
                                if (m > 0) {
                                    System.out.printf("Congratulations!! Discount: %.1f percent of %.2f = %.2f\n", m, z, (z * m) / 100);
                                }
                                if(C.coupon_values.size()>0){
                                    C.coupon_values.remove(C.coupon_values.get(C.coupon_values.size() - 1));}
                            }
                        } else if (C.status == 1) {
                            if(t1.getNormal_discount()>0){
                                System.out.printf("Congratulations!! Discount: %.1f percent of %.2f = %.2f\n", t1.getNormal_discount(), z, (z * t1.getNormal_discount()) / 100);}
                        } else if (C.status == 2) {
                            if (t1.getPrime_discount() >= 5 && t1.getPrime_discount() >=m) {
                                System.out.printf("Congratulations!! Discount: %.1f percent of %.2f = %.2f\n", t1.getPrime_discount(), z, (z * t1.getPrime_discount()) / 100);
                            } else if (t1.getPrime_discount() <= 5 && m <= 5) {
                                System.out.printf("Congratulations!! Discount: 5 percent of %.2f = %.2f\n", z, z / 20);
                            } else {
                                if (m > 0) {
                                    System.out.printf("Congratulations!! Discount: %.1f percent of %.2f = %.2f\n", m, z, (z * m) / 100);
                                }
                                if(C.coupon_values.size()>0){
                                    C.coupon_values.remove(C.coupon_values.get(C.coupon_values.size() - 1));}
                            }
                        }

                    }
                }
            }
            if(C.Deal_Cart.size()!=0){
                System.out.println("Details of Deal Items:-");
                int d1 = 1;
                for (Deal d : C.Deal_Cart){
                    System.out.println("Deal "+d1+" Contains:-");
                    System.out.println(1+")  Category: "+ d.getP1().getCategory_name());
                    System.out.println("    Product name: "+ d.getP1().getProduct_name());
                    System.out.println("    Product ID: "+ d.getP1().getProduct_id());
                    System.out.println("    Price: Rs " + d.getP1().getPrice() +"/-");
                    System.out.println("    Quantity: "+1);
                    System.out.println("    Details: "+ d.getP1().getOther_details());
                    System.out.print("\n");

                    System.out.println(2+")  Category: "+ d.getP2().getCategory_name());
                    System.out.println("    Product name: "+ d.getP2().getProduct_name());
                    System.out.println("    Product ID: "+ d.getP2().getProduct_id());
                    System.out.println("    Price: Rs " + d.getP2().getPrice() +"/-");
                    System.out.println("    Quantity: "+1);
                    System.out.println("    Details: "+ d.getP2().getOther_details());
                    System.out.print("\n");
                    if(C.status==0){
                        System.out.println("Deal Price: Rs "+ d.getPrice_elite()+"/-");
                    }
                    else if(C.status==1){
                        System.out.println("Deal Price: Rs "+ d.getPrice_normal()+"/-");
                    }
                    else if(C.status==2){
                        System.out.println("Deal Price: Rs "+ d.getPrice_prime()+"/-");
                    }
                    int q1 = d.getQuantity();
                    q1-=d.getBy_quantity();
                    d.setQuantity(q1);
                    System.out.print("\n");
                    d1++;
                }
            }
            if(b>5000 && C.status==0){
                System.out.println("Congratulations you have earned 4 coupons for order value of more than 5000 Rs.");
                int min = 5;
                int max = 15;
                for (int i=0; i<4; i++){
                    int a = (int) (Math.random()*(max-min+1)+min);
                    C.coupon_values.add(a);
                }
            }
            else if(b>5000 && C.status==2){
                System.out.println("Congratulations you have earned 2 coupons for order value of more than 5000 Rs.");
                int min = 5;
                int max = 15;
                for (int i=0; i<2; i++){
                    int a = (int) (Math.random()*(max-min+1)+min);
                    C.coupon_values.add(a);
                }
            }
            C.Cart.clear();
            C.Deal_Cart.clear();
            System.out.println("Delivery charges: Rs "+charges+"/-");
            C.balance-=total_cost;
            System.out.printf("Total Cost: Rs %.2f/-\n",total_cost);
            if(C.status==0){
                System.out.println("You order will be delivered within 2 days");
            }
            else if(C.status==1){
                System.out.println("You order will be delivered within 7-10 days");
            }
            else if(C.status==2){
                System.out.println("You order will be delivered within 3-6 days");
            }
        }
        }

}
class Product{
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    private int available;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    private int category_id;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    private String category_name;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    private String product_name;

    public float getProduct_id() {
        return product_id;
    }

    public void setProduct_id(float product_id) {
        this.product_id = product_id;
    }

    private float product_id;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;

    public String getOther_details() {
        return Other_details;
    }

    private final String Other_details;

    public float getElite_discount() {
        return elite_discount;
    }

    public void setElite_discount(float elite_discount) {
        this.elite_discount = elite_discount;
    }

    private float elite_discount;

    public float getNormal_discount() {
        return normal_discount;
    }

    public void setNormal_discount(float normal_discount) {
        this.normal_discount = normal_discount;
    }

    private float normal_discount;

    public float getPrime_discount() {
        return prime_discount;
    }

    public void setPrime_discount(float prime_discount) {
        this.prime_discount = prime_discount;
    }

    private float prime_discount;
    Product(int c,String s, String y, float x, float p, String o,int d){
        this.category_id=c;
        this.category_name = s;
        this.product_name = y;
        this.product_id = x;
        this.price = p;
        this.Other_details = o;
        this.available = d;
    }
}
class Deal{
    public int getBy_quantity() {
        return by_quantity;
    }

    public void setBy_quantity(int by_quantity) {
        this.by_quantity = by_quantity;
    }

    private int by_quantity;
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public Product getP1() {
        return P1;
    }

    public void setP1(Product p1) {
        P1 = p1;
    }

    private Product P1;

    public Product getP2() {
        return P2;
    }

    public void setP2(Product p2) {
        P2 = p2;
    }

    private Product P2;

    public float getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(float deal_id) {
        this.deal_id = deal_id;
    }

    private float deal_id;

    public float getPrice_normal() {
        return price_normal;
    }

    public void setPrice_normal(float price_normal) {
        this.price_normal = price_normal;
    }

    private float price_normal;

    public float getPrice_elite() {
        return price_elite;
    }

    public void setPrice_elite(float price_elite) {
        this.price_elite = price_elite;
    }

    private float price_elite;

    public float getPrice_prime() {
        return price_prime;
    }

    public void setPrice_prime(float price_prime) {
        this.price_prime = price_prime;
    }

    private float price_prime;
    Deal(Product s1, Product s2){
        this.P1=s1;
        this.P2=s2;
    }
}
