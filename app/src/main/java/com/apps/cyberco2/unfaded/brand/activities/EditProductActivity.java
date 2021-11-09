package com.apps.cyberco2.unfaded.brand.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.expandablemodel.Child;
import com.apps.cyberco2.unfaded.brand.model.expandablemodel.Parent;
import com.apps.cyberco2.unfaded.databinding.ActivityEditProductBinding;

import iammert.com.expandablelib.ExpandCollapseListener;
import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;

public class EditProductActivity extends AppCompatActivity {
    ActivityEditProductBinding productBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_product);

        // Category
        productBinding.spinnerCategory.setRenderer(new ExpandableLayout.Renderer<Parent, Child>() {

            @Override
            public void renderParent(View view, Parent model, boolean isExpanded, int parentPosition) {
                ((TextView) view.findViewById(R.id.tv_parent)).setText(model.getCategoryname());
                view.findViewById(R.id.parent_arrow);
            }

            @Override
            public void renderChild(View view, Child model, int parentPosition, int childPosition) {
                ((TextView) view.findViewById(R.id.tvChild)).setText(model.getName());
            }
        });
        productBinding.spinnerCategory.addSection(getSection());
        productBinding.spinnerCategory.setExpandListener(new ExpandCollapseListener.ExpandListener<Parent>() {
            @Override
            public void onExpanded(int parentIndex, Parent parent, View view) {
                ImageView img = view.findViewById(R.id.parent_arrow);
                img.setImageResource(R.drawable.ic_spinner_up);
            }
        });
        productBinding.spinnerCategory.setCollapseListener(new ExpandCollapseListener.CollapseListener<Parent>() {
            @Override
            public void onCollapsed(int parentIndex, Parent parent, View view) {
                ImageView img = view.findViewById(R.id.parent_arrow);
                img.setImageResource(R.drawable.ic_spinner_down);
            }
        });
        // Type
        productBinding.spinnerType.setRenderer(new ExpandableLayout.Renderer<Parent, Child>() {

            @Override
            public void renderParent(View view, Parent model, boolean isExpanded, int parentPosition) {
                ((TextView) view.findViewById(R.id.tv_parent)).setText(model.getCategoryname());
                view.findViewById(R.id.parent_arrow);
            }

            @Override
            public void renderChild(View view, Child model, int parentPosition, int childPosition) {
                ((TextView) view.findViewById(R.id.tvChild)).setText(model.getName());
            }
        });
        productBinding.spinnerType.addSection(getSection2());
        productBinding.spinnerType.setExpandListener(new ExpandCollapseListener.ExpandListener<Parent>() {
            @Override
            public void onExpanded(int parentIndex, Parent parent, View view) {
                ImageView img = view.findViewById(R.id.parent_arrow);
                img.setImageResource(R.drawable.ic_spinner_up);
            }
        });
        productBinding.spinnerType.setCollapseListener(new ExpandCollapseListener.CollapseListener<Parent>() {
            @Override
            public void onCollapsed(int parentIndex, Parent parent, View view) {
                ImageView img = view.findViewById(R.id.parent_arrow);
                img.setImageResource(R.drawable.ic_spinner_down);
            }
        });
    }

    public Section<Parent, Child> getSection() {
        Section<Parent, Child> section = new Section<>();
        Parent fruitParent = new Parent("Product Category");
        Child fruit1 = new Child("Jeans");
        Child fruit2 = new Child("Shirts");
        Child fruit3 = new Child("Shoes");
        Child fruit4 = new Child("Skirts");
        section.parent = fruitParent;
        section.children.add(fruit1);
        section.children.add(fruit2);
        section.children.add(fruit3);
        section.children.add(fruit4);


        return section;
    }

    public Section<Parent, Child> getSection2() {
        Section<Parent, Child> section = new Section<>();
        Parent fruitParent = new Parent("Type");
        Child fruit1 = new Child("Formal");
        Child fruit2 = new Child("Casual");
        Child fruit3 = new Child("Street Style");
        Child fruit4 = new Child("Party");
        section.parent = fruitParent;
        section.children.add(fruit1);
        section.children.add(fruit2);
        section.children.add(fruit3);
        section.children.add(fruit4);


        return section;
    }
}
