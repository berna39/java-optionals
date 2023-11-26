package com.terminator;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        // Basics
        Optional<Object> obj = Optional.empty();
        System.out.println(obj.isPresent());

        // orElse
        Optional<String> hello = Optional.of("Hello");
        Optional<String> helloBis = Optional.empty();

        String orElse = hello.orElse(hello.orElse("Hi"));
        String orElseBis = helloBis.orElse("Hey there!");
        System.out.println(orElse);
        System.out.println(orElseBis);


        // Map
        Optional<String> sentence = Optional.of("Make your spirit great again");
        String upper = sentence.map(String::toUpperCase).get();
        System.out.println(upper);

        // Filtering
        Optional<String> player = Optional.of("Suarez");
        String res = player.filter(p -> p.length() > 3).get(); 
        System.out.println(res);

        // Checking after filtering
        Optional<String> goalKeeper = Optional.of("Martinez");
        // String resBis = goalKeeper.filter(g -> g.length() > 9).get(); // will throw NPE
        // at the moment that we filter, we can have a null result...so, we need to check the result before downStreaming
        String checkedResult = goalKeeper.filter(g -> g.length() > 9).orElse("No result");
        System.out.println(checkedResult);


        // ifPresent, ifPresentOrElse
        Optional<String> name = Optional.of("Toby");
        name.ifPresent(System.out::println);

        // name.ifPresentOrElse(System.out::println, () -> { 
        //     System.out.println("Yo");
        // });

        
        // orElse & orElseGet
        Optional<String> arsenal = Optional.empty();
        String teamRes = arsenal.orElse("Liverpool"); // we pass an option directly
        System.out.println(teamRes);

        String teamResBis = arsenal.orElseGet(() -> { return "Westham"; }); // we pass a Supplier
        System.out.println(teamResBis);

        // orElseThrough
        Optional<String> country = Optional.empty();
        String countryRes = country.orElseThrow(IllegalArgumentException::new);
        System.out.println(countryRes);

        // in newer Java versions, we can only use country.orElseThrow();, it will create an exception instance only
    }
}
