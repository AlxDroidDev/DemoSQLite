package alxdroiddev.com.demosqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/********************************************************************************************
 *
 * Project    :   DemoSQLite
 * Package    :   alxdroiddev.com.demosqlite.db
 * Author     :   Alex Simonetti (AlxDroidDev)
 * Data       :   12/05/2017
 *
 * Description: 
 *
 *******************************************************************************************/

public final class DatabaseHelper extends SQLiteOpenHelper {

    static  final  int DATABASE_VERSION = 1;
    static  final  String DATABASE_NAME = "MeuExemplo.db";

    public  DatabaseHelper  (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON");

        /* Tabelas e índices */

        String ddlSql = "CREATE TABLE Departamento (CodDepto integer primary key not null," +
                                                   "NomeDepto char(50) not null collate nocase," +
                                                   "NumFuncionarios integer not null default (0));";
        db.execSQL(ddlSql);

        db.execSQL("CREATE UNIQUE INDEX idxDeptoNome on Departamento(NomeDepto)");

        ddlSql = "CREATE TABLE Empregado (CodEmpregado integer primary key not null," +
                                         "NomeEmpregado char(80) not null collate nocase," +
                                         "CodDepto integer not null references Departamento (CodDepto) on delete restrict," +
                                         "CodEmpregadoSupervisor integer null references Empregado(CodEmpregado) on delete set null," +
                                         "CPF char(11) not null," +
                                         "DataCadastro datetime not null default(date('now'))," +
                                         "DataNascimento datetime null," +
                                         "Salario decimal not null default (0)," +
                                         "Foto blob null," +
                                         "DataAdmissao datetime not null default(date('now'))," +
                                         "DataDemissao datetime null," +
                                         "Observacoes text null collate nocase);";
        db.execSQL(ddlSql);

        db.execSQL("CREATE INDEX idxEmpregadoNome on Empregado(NomeEmpregado)");
        db.execSQL("CREATE UNIQUE INDEX idxEmpregadoCPF on Empregado(CPF)");


        ddlSql = "CREATE TABLE HistoricoSalario (CodEmpregado integer not null references Empregado(CodEmpregado) on delete cascade," +
                                              "DataAlteracao date not null default(date('now'))," +
                                              "ValorAntigo decimal not null default(0)," +
                                              "ValorNovo decimal not null);";
        db.execSQL(ddlSql);


        /* Views */
        ddlSql = "CREATE VIEW DepartamentoSalario AS " +
                      "SELECT A.NomeDepto, sum(B.Salario) as SomaSalarios" +
                      "FROM Departamento A JOIN Empregado B on (A.CodDepto = B.CodDepto) " +
                      "WHERE (B.DataAdmissao <= date('now')) AND (B.DataDemissao is null)" +
                      "GROUP BY A.NomeDepto";
        db.execSQL(ddlSql);







    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
