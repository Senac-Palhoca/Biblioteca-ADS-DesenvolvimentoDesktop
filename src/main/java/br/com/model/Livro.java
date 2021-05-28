/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "livro")
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    private String edicao;
    @Column(nullable = false)
    private String editora;
    @Column(nullable = false, unique = true)
    private String isbn;

    @OneToMany
    @JoinColumn(name = "id_livro")
    private List<Exemplar> exemplares;

    public Livro() {
    }

    public Livro(String titulo, String autor, String edicao, String editora, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.editora = editora;
        this.isbn = isbn;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this. titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this. autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this. edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this. editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this. isbn = isbn;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro)object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "br.com.modelo.Livro[ id=" + id + "]";
    }
}
