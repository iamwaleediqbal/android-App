package com.apps.cyberco2.unfaded.customer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.customer.fragments.CartFragment;
import com.apps.cyberco2.unfaded.customer.fragments.HomeCustomerFragment;
import com.apps.cyberco2.unfaded.customer.fragments.ProfileCustomerFragment;
import com.apps.cyberco2.unfaded.customer.fragments.SearchFragment;
import com.apps.cyberco2.unfaded.customer.fragments.WishListFragment;
import com.apps.cyberco2.unfaded.databinding.ActivityMainCustomerBinding;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import static com.apps.cyberco2.unfaded.utils.Constants.CART_ID;
import static com.apps.cyberco2.unfaded.utils.Constants.HOME_ID;
import static com.apps.cyberco2.unfaded.utils.Constants.SEARCH_ID;
import static com.apps.cyberco2.unfaded.utils.Constants.USER_ID;
import static com.apps.cyberco2.unfaded.utils.Constants.WISHLIST_ID;

public class MainCustomerActivity extends AppCompatActivity {
    ActivityMainCustomerBinding customerBinding;
    MeowBottomNavigation bottomNavigation;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customerBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_customer);
        bottomNavigation = customerBinding.bottomNav;
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        bottomNavigation.add(new MeowBottomNavigation.Model(SEARCH_ID, R.drawable.ic_search_product));
        bottomNavigation.add(new MeowBottomNavigation.Model(WISHLIST_ID, R.drawable.ic_wishlist));
        bottomNavigation.add(new MeowBottomNavigation.Model(HOME_ID, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(CART_ID, R.drawable.ic_cart));
        bottomNavigation.add(new MeowBottomNavigation.Model(USER_ID, R.drawable.ic_user));
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //   Toast.makeText(MainAc tivity.this, "Show item : " + item.getId(), Toast.LENGTH_SHORT).show();
                switch (item.getId()) {
                    case HOME_ID:
                        HomeCustomerFragment homeFragment = new HomeCustomerFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, homeFragment)
                            .setPrimaryNavigationFragment(homeFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case SEARCH_ID:
                        SearchFragment searchFragment = new SearchFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, searchFragment)
                            .setPrimaryNavigationFragment(searchFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case WISHLIST_ID:
                        WishListFragment wishListFragment = new WishListFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, wishListFragment)
                            .setPrimaryNavigationFragment(wishListFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case CART_ID:
                        CartFragment cartFragment = new CartFragment();

                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, cartFragment)
                            .setPrimaryNavigationFragment(cartFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case USER_ID:
                        ProfileCustomerFragment customerFragment = new ProfileCustomerFragment();

                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, customerFragment)
                            .setPrimaryNavigationFragment(customerFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    default:
                }
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                switch (item.getId()) {
                    case HOME_ID:
                        HomeCustomerFragment homeFragment = new HomeCustomerFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, homeFragment)
                            .setPrimaryNavigationFragment(homeFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case SEARCH_ID:
                        SearchFragment searchFragment = new SearchFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, searchFragment)
                            .setPrimaryNavigationFragment(searchFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case WISHLIST_ID:
                        WishListFragment wishListFragment = new WishListFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, wishListFragment)
                            .setPrimaryNavigationFragment(wishListFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case CART_ID:
                        CartFragment cartFragment = new CartFragment();

                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, cartFragment)
                            .setPrimaryNavigationFragment(cartFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case USER_ID:
                        ProfileCustomerFragment customerFragment = new ProfileCustomerFragment();

                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, customerFragment)
                            .setPrimaryNavigationFragment(customerFragment)
                            // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    default:
                }
            }
        });
        bottomNavigation.show(HOME_ID, true);
    }
}
