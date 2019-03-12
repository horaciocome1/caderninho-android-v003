package com.tumblr.b1moz.caderninho003.assets;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyReviewListRecyclerviewAdapter;
import com.tumblr.b1moz.caderninho003.domain.Costumer;
import com.tumblr.b1moz.caderninho003.domain.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public ReviewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.general_recyclerview, container, false);

        if (view instanceof RecyclerView) {
            mRecyclerView = (RecyclerView) view;
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            mRecyclerView.setAdapter(new MyReviewListRecyclerviewAdapter(getReviewList(12)));
        }

        return view;
    }

    private List<Review> getReviewList(int size) {
        List<Review> reviews = new ArrayList<>();
        Review review;
        Costumer costumer;

        for (int i = 0; i < size; i++) {
            costumer = new Costumer();
            costumer.setName("Anilza Cynthia");
            review = new Review();
            review.setCostumer(costumer);
            review.setReview(5);
            review.setComment("O transporte foi muito rapido. O motorista avisou com antecedencia que se aproximava da minha paragem e assim consegui " +
                    "chegar a tempo de levar a minha encomenda. A encomenda chegou em bom estado e o selo de verificacao estava intacto. E a verificacao " +
                    "do carro foi muito facil com as fotos disponiveis e a matricula. Recomendo a todos! Obrigado!");
            review.setDate("11/09/2018");
            reviews.add(review);

            costumer = new Costumer();
            costumer.setName("Jose Antonio");
            review = new Review();
            review.setCostumer(costumer);
            review.setReview(1);
            review.setComment("Pessimo. So me avisou faltando uma paragem. Ainda por cima deixou meu pacote no deposito e nao atendeu as minhas chamadas");
            review.setDate("11/09/2018");
            reviews.add(review);

            costumer = new Costumer();
            costumer.setName("Vicki Icki Sicky");
            review = new Review();
            review.setCostumer(costumer);
            review.setReview(3);
            review.setComment("O carro eh muito diferente do que aparece nas fotos. Foi muito dificil reconhecer.");
            review.setDate("14/08/2018");
            reviews.add(review);

            costumer = new Costumer();
            costumer.setName("Sergio Lusaka");
            review = new Review();
            review.setCostumer(costumer);
            review.setReview(2);
            review.setComment("O transporte foi muito lento! teria sido melhor ir buscar o pacote pessoalmente!");
            review.setDate("30/06/2018");
            reviews.add(review);

            costumer = new Costumer();
            costumer.setName("Graca dos Anjos");
            review = new Review();
            review.setCostumer(costumer);
            review.setReview(4);
            review.setComment("Muito bom. Avisa sobre a sua localizacao. Apenas foi demasiado apressado na hora da verificacao!");
            review.setDate("28/06/2018");
            reviews.add(review);
        }

        return reviews;
    }

}
