/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Felipe
 */
@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Funcionario extends Pessoa implements Serializable{

}
