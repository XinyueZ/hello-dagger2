# Say hello to Dagger2 of Google on Android

> Do thing indirectly, do thing independently.

# What we do generally

We have variable ```foo``` of type ```Foo``` and we have different ways to create an instance of it like below:

```
class Foo {
    doFool();
}

Foo foo = new Foo();

//Or....

class Factory {
    Foo craete() {
        return new Foo();
    }
}


Foo foo = new Factory().create();


//Or...

class Business {
    Foo doSomeBusiness() {
        ..
        ...
        return new Foo();
    }
}

Business bs = new Business();
.....
foo = bs.doSomeBusiness();
.
...
if(foo != null)
    foo.doFool();
...

//Or...
....
...
```

As you've seen we use upon codes almost in every projects. The couplings between the target ```variable``` and different components that can create target is explicitly. 
To solve the couplings we'll use the design-patterns like factory or delegates instinctly, however, before we use pattern we must also know who they are, where they are and what they can do. That means without
them the  ```foo``` may not be created possibly, and the client oder consumer who uses ```variable``` will be high dependently on it.

# What we can change with Dagger2

> We don't want to know how  ```foo``` will be created, or we don't care how many methods that can create it.

```
@inject Foo foo;
..
Dagger2(foo);
....
foo.doFool();

```

# Start


