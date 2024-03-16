/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.berkeko.online.shopping;

import com.berkeko.online.shopping.model.Customer;
import com.berkeko.online.shopping.model.ExampleDatabaseInitializer;
import com.berkeko.online.shopping.model.Order;
import com.berkeko.online.shopping.model.Product;
import java.util.Optional;
import java.util.Arrays;

/**
 *
 * @author berkeko
 */
public class OnlineShopping {

    public static void main(String[] args) {
        ExampleDatabaseInitializer example = new ExampleDatabaseInitializer();
        example.initialize();
        
        // Bir müşteri birden fazla sipariş verebilir.
        // Bir sipariş içerisinde birden fazla ürün olabilir
        System.out.println("Bir musteri birden fazla siparis verebilir, birden fazla urun olabilir, urun kategori, isim ve stok bilgisi, ve her siparisin faturasi: \n");
        Optional<Customer> customerOptional = example.getCustomerDatabase().getCustomer("berkekocadere@gmail.com");
        Customer customer = customerOptional.orElse(null);
        
        Optional<Product> product1Optional = example.getProductDatabase().getProduct("Bilgisayar");
        Product product1 = product1Optional.orElse(null);
        Optional<Product> product2Optional = example.getProductDatabase().getProduct("Cep Telefonu");
        Product product2 = product2Optional.orElse(null);
        
        Optional<Product> product3Optional = example.getProductDatabase().getProduct("Koltuk");
        Product product3 = product3Optional.orElse(null);
        
        if (customer != null && product1 != null && product2 != null && product3 != null) {                    
            customer.addOrder(new Order(customer, Arrays.asList(product1, product2)));
            customer.addOrder(new Order(customer, Arrays.asList(product3)));

            customer.getOrderList().forEach(order -> {
                System.out.println("Order : " + order + "\n");
                System.out.println(order.getInvoice().toString());
                System.out.println("///////////////////// \n");
            });
        }
        
        // Diger Berke isimli kullanici
        customerOptional = example.getCustomerDatabase().getCustomer("berkekucukdere@gmail.com");
        customer = customerOptional.orElse(null);
        
        product1Optional = example.getProductDatabase().getProduct("Pantolon");
        product1 = product1Optional.orElse(null);
        
        if (customer != null && product1 != null) {                    
            customer.addOrder(new Order(customer, Arrays.asList(product1)));
        }
        ////////////////////////////////////////////////////////
        
        // Sistemdeki bütün müşterisi sayısını bulan,
        System.out.println("Sistemdeki butun musteriler : \n");
        example.getCustomerDatabase().getCustomerList().forEach(cs -> {
            System.out.println(cs.toString());
            System.out.println("/////////////////////");
        });
        
        // İsmi Berke olan müşterilerin aldıkları ürün sayısını bulan,
        System.out.println("Ismi Berke olan musterilerin aldiklari urun sayisi : ");
        System.out.println(example.getCustomerDatabase().getProductCountForCustomer("Berke"));
        
        // İsmi Berke olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını hesaplayın
        double totalPrice = example.getCustomerDatabase().getRangeOfCustomersTotalPrice("Berke", 25, 30);
        System.out.println("Total purchase amount for customers named Berke, aged between 25 and 30: " + totalPrice);    
        
        // Sistemdeki 1500 TL üzerindeki faturaları listeleyin.
        System.out.println("Sistemdeki 1500 TL uzerindeki faturalari listeleyin. \n");
        System.out.println(example.getCustomerDatabase().getInvoicesWithTotalBillMoreThanAmount(1500));
    }
}
