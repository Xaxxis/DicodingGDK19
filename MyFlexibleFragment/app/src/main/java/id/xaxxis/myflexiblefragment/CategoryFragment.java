package id.xaxxis.myflexiblefragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void  onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_detail_category){
            DetailCategoryFragment detailCategoryFragment = new DetailCategoryFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            String description = "Kategori ini akan berisi produk-produk lifestyle";

            detailCategoryFragment.setArguments(bundle);
            detailCategoryFragment.setDescription(description);

            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null){
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment.class.getSimpleName());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

        }
    }
}
