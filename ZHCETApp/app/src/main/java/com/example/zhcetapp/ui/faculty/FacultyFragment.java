package com.example.zhcetapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zhcetapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment, electronicsDepartment, electricalDepartment, mechanicalDepartment, civilDepartment, chemicalDepartment, petroDepartment;
    private LinearLayout csNoData, electronicsNoData, electricalNoData, mechanicalNoData, civilNoData, chemicalNoData, petroNoData;
    private List<TeachersData> list1, list2, list3, list4, list5, list6, list7;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);

        csDepartment = view.findViewById(R.id.csDepartment);
        electronicsDepartment = view.findViewById(R.id.electronicsDepartment);
        electricalDepartment = view.findViewById(R.id.electricalDepartment);
        mechanicalDepartment = view.findViewById(R.id.mechanicalDepartment);
        civilDepartment = view.findViewById(R.id.civilDepartment);
        chemicalDepartment = view.findViewById(R.id.chemicalDepartment);
        petroDepartment = view.findViewById(R.id.petroDepartment);

        csNoData = view.findViewById(R.id.csNoData);
        electronicsNoData= view.findViewById(R.id.electronicsNoData);
        electricalNoData = view.findViewById(R.id.electricalNoData);
        mechanicalNoData = view.findViewById(R.id.mechanicalNoData);
        civilNoData = view.findViewById(R.id.civilNoData);
        chemicalNoData = view.findViewById(R.id.chemicalNoData);
        petroNoData = view.findViewById(R.id.petroNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        electronicsDepartment();
        electricalDepartment();
        mechanicalDepartment();
        civilDepartment();
        chemicalDepartment();
        petroDepartment();

   return view;
    }


    private void csDepartment() {
        dbRef = reference.child("Computer Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                } else {

                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list1.add(data);

                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    csDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void electronicsDepartment() {
        dbRef = reference.child("Electronics and Communication");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    electronicsNoData.setVisibility(View.VISIBLE);
                    electronicsDepartment.setVisibility(View.GONE);
                }
                else {

                    electronicsNoData.setVisibility(View.GONE);
                    electronicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeachersData data =snapshot.getValue(TeachersData.class);
                        list2.add(data);

                    }
                    electronicsDepartment.setHasFixedSize(true);
                    electronicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    electronicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void electricalDepartment() {
        dbRef = reference.child("Electrical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    electricalNoData.setVisibility(View.VISIBLE);
                    electricalDepartment.setVisibility(View.GONE);
                } else {

                    electricalNoData.setVisibility(View.GONE);
                    electricalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list3.add(data);

                    }
                    electricalDepartment.setHasFixedSize(true);
                    electricalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    electricalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void mechanicalDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    mechanicalNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                } else {

                    mechanicalNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list4.add(data);

                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    mechanicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void civilDepartment() {
        dbRef = reference.child("Civil");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    civilNoData.setVisibility(View.VISIBLE);
                    civilDepartment.setVisibility(View.GONE);
                }

                else {

                    csNoData.setVisibility(View.GONE);
                    civilDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list5.add(data);

                    }
                    civilDepartment.setHasFixedSize(true);
                    civilDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    civilDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void  chemicalDepartment() {
        dbRef = reference.child("Chemical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    chemicalNoData.setVisibility(View.VISIBLE);
                    chemicalDepartment.setVisibility(View.GONE);
                } else {

                    chemicalNoData.setVisibility(View.GONE);
                    chemicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list6.add(data);

                    }
                    chemicalDepartment.setHasFixedSize(true);
                    chemicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6, getContext());
                    chemicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void petroDepartment() {
        dbRef = reference.child("Petrochemical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    petroNoData.setVisibility(View.VISIBLE);
                    petroDepartment.setVisibility(View.GONE);
                } else {

                    petroNoData.setVisibility(View.GONE);
                    petroDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list7.add(data);

                    }
                    petroDepartment.setHasFixedSize(true);
                    petroDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7, getContext());
                    petroDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
