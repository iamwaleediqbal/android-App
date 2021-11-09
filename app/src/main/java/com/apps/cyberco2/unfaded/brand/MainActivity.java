package com.apps.cyberco2.unfaded.brand;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.fragments.AddProductFragment;
import com.apps.cyberco2.unfaded.brand.fragments.CollectionFragment;
import com.apps.cyberco2.unfaded.brand.fragments.HomeFragment;
import com.apps.cyberco2.unfaded.brand.fragments.ProfileFragment;
import com.apps.cyberco2.unfaded.brand.fragments.WalletFragment;
import com.apps.cyberco2.unfaded.databinding.ActivityMainBinding;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import static com.apps.cyberco2.unfaded.utils.Constants.ADD_PRODUCT_ID;
import static com.apps.cyberco2.unfaded.utils.Constants.COLLECTION_ID;
import static com.apps.cyberco2.unfaded.utils.Constants.HOME_ID;
import static com.apps.cyberco2.unfaded.utils.Constants.USER_ID;
import static com.apps.cyberco2.unfaded.utils.Constants.WALLET_ID;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    MeowBottomNavigation bottomNavigation;
    String name;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bottomNavigation = mainBinding.bottomNav;
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        bottomNavigation.add(new MeowBottomNavigation.Model(ADD_PRODUCT_ID, R.drawable.ic_add_product));
        bottomNavigation.add(new MeowBottomNavigation.Model(WALLET_ID, R.drawable.ic_wallet));
        bottomNavigation.add(new MeowBottomNavigation.Model(HOME_ID, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(COLLECTION_ID, R.drawable.ic_collection));
        bottomNavigation.add(new MeowBottomNavigation.Model(USER_ID, R.drawable.ic_user));
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(MainActivity.this, "clicked item : " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //   Toast.makeText(MainActivity.this, "Show item : " + item.getId(), Toast.LENGTH_SHORT).show();
                switch (item.getId()) {
                    case HOME_ID:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, homeFragment)
                            .setPrimaryNavigationFragment(homeFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case ADD_PRODUCT_ID:
                        AddProductFragment addProductFragment = new AddProductFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, addProductFragment)
                            .setPrimaryNavigationFragment(addProductFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case COLLECTION_ID:
                        CollectionFragment collectionFragment = new CollectionFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, collectionFragment)
                            .setPrimaryNavigationFragment(collectionFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case USER_ID:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, profileFragment)
                            .setPrimaryNavigationFragment(profileFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case WALLET_ID:
                        WalletFragment walletFragment = new WalletFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, walletFragment)
                            .setPrimaryNavigationFragment(walletFragment) // equivalent to app:defaultNavHost="true"
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
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, homeFragment)
                            .setPrimaryNavigationFragment(homeFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case ADD_PRODUCT_ID:
                        AddProductFragment addProductFragment = new AddProductFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, addProductFragment)
                            .setPrimaryNavigationFragment(addProductFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case COLLECTION_ID:
                        CollectionFragment collectionFragment = new CollectionFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, collectionFragment)
                            .setPrimaryNavigationFragment(collectionFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case USER_ID:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, profileFragment)
                            .setPrimaryNavigationFragment(profileFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    case WALLET_ID:
                        WalletFragment walletFragment = new WalletFragment();
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, walletFragment)
                            .setPrimaryNavigationFragment(walletFragment) // equivalent to app:defaultNavHost="true"
                            .commit();
                        break;
                    default:
                }
            }
        });
        bottomNavigation.show(HOME_ID, true);

    }

}
