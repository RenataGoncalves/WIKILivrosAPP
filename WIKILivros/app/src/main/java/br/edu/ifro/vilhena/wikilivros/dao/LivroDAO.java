package br.edu.ifro.vilhena.wikilivros.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.ifro.vilhena.wikilivros.model.Livro;

public class LivroDAO extends SQLiteOpenHelper {


    public LivroDAO(Context context) { super(context, "WIKILivros", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table livros (id integer primary key, ano integer, paginas integer, nota integer, classificacao integer, nome text, genero text, editora text, autor text, sinopse text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserir(Livro livro){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("ano", livro.getAno());
        dados.put("paginas", livro.getPaginas());
        dados.put("nota", livro.getNota());
        dados.put("classificacao", livro.getClassificacao());
        dados.put("nome", livro.getNome());
        dados.put("genero", livro.getGenero());
        dados.put("editora", livro.getEditora());
        dados.put("autor", livro.getAutor());
        dados.put("sinopse", livro.getSinopse());

        db.insert("livros", null, dados);
    }

    public void deletar(Livro livro){
        SQLiteDatabase db = getWritableDatabase();
        String[] parametros = {String.valueOf(livro.getId())};
        db.delete("livros", "id = ?", parametros);
    }

    public void alterar(Livro livro){
        SQLiteDatabase db = getWritableDatabase();
        String[] parametros = {String.valueOf(livro.getId())};
        ContentValues dados = new ContentValues();
        dados.put("ano", livro.getAno());
        dados.put("paginas", livro.getPaginas());
        dados.put("nota", livro.getNota());
        dados.put("classificacao", livro.getClassificacao());
        dados.put("nome", livro.getNome());
        dados.put("genero", livro.getGenero());
        dados.put("editora", livro.getEditora());
        dados.put("autor", livro.getAutor());
        dados.put("sinopse", livro.getSinopse());
        db.update("livros",dados, "id = ?", parametros);
    }

}
