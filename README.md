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

What should the ```variable```s do so that ehy can be created gracefully and independently ? 
The answer is easy, give them an annotation ```@Inject```.

```
@Inject Foo foo;
..
Dagger2(foo);
....
foo.doFool();

```

# Start with example

We define a world named "society" and it has a "playground", a "company" , a "software developer group". The "company" has one boss, one super-user. The "software developer group" has "boss", "super-user", "internal user", "external-user". In our example we only print out some information with ```toString()``` .

1. Show all in ```SocietyActivity```, we define variable of ```Playground``` with ``` @Inject  ```, that means we don't care how it is created, it might be created "automatically". 
 
 ```java
  
public final class Playground {
	private String mPemo;

	@Inject
	public Playground() {
		mPemo = "Playground is playground, it is simple";
	}

	@Override
	public String toString() {
		return mPemo +   "\n\n";
	}
}


 public final class SocietyActivity extends AppCompatActivity {
 	@Inject Playground mPlayground;
 
 	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 	} 
 }
 
 ```
2. We use data-binding to create basic layout, and try to use ```mPlayground``` to print out some information.
 ```java
 public final class SocietyActivity extends AppCompatActivity {
 	@Inject Playground mPlayground;
 	private ActivityMainBinding mBinding;
 
 	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
  
 		mBinding.playgroundOutputTv.setText("Playground: \n\n" + mPlayground.toString());
    } 
 }
 ```
**Oha , if we build the app, CRASH, because the ```mPlayground``` can not be created automatically.**

### How to create objects that we need?

1. We introduce **Component**, that can create, build, give variables of ```@Inject``` an instance of it in target place.
 
 ```java
 @Component
 public interface SocietyComponent {
 	void createSociety(SocietyActivity activity);
 }
 ```
 - ```createSociety``` provides input for target place who needs creation of the variables of ```@Inject``` .
 - ```SocietyActivity activity``` is the target place contains  the variables of ```@Inject```, here is ```@Inject Playground mPlayground```.
 - In ```Playground``` we define default constructor with annotation ```@Inject```, means "Hi, I can provide at least an instance automatically" for those who have ```@Inject``` .

2. Run the app, if can not build, do **clean**  and run it. You'll see the output of ```mPlayground```, with luck of ```Inject```, it has been created automatically.

 


