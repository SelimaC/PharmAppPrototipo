package com.example.selima.pharmapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.selima.pharmapp.model.Assumption;
import com.example.selima.pharmapp.model.Medicine;
import com.example.selima.pharmapp.model.OccasionalMedicine;
import com.example.selima.pharmapp.model.Schedule;
import com.example.selima.pharmapp.model.Tag;
import com.example.selima.pharmapp.model.Therapy;
import com.example.selima.pharmapp.model.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by selim on 16/02/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PharmAppDB";
    public static final int DATABASE_VERSION=1;

    public static final String CREATE_USER = "create table Patient (codPatient text primary key, password text not null);";
    public static final String CREATE_OCCASIONAL_MEDICINE = "create table OccasionalMedicine( idMedicine integer primary key autoincrement, name text not null, amount real not null, unit text check(unit in ('pillole','fiale','mg','ml','goccie','bustine')) not null, date text not null, time text not null, patient text references Patient(codPatient) not null on delete cascade on update cascade );";
    public static final String CREATE_THERAPY = "create table Therapy( idTherapy integer primary key autoincrement, medicine text references Medicine(idMedicine) not null on delete cascade on update cascade, dailyFrequency integer check(dailyFrequency>0) not null, startDate text not null, duration integer not null, dayFrequency integer check(dayFrequency>0) not null, stock integer check(stock>0) not null, limitStock integer check(limitStock>=0) not null, notificationStock integer not null, patient char(10) references patient(codPatient) not null on delete cascade on update cascade );";
    public static final String CREATE_MEDICINE = "create table Medicine( idMedicine integer primary key autoincrement, name text not null, unit text check(unit in ('pillole','fiale','mg','ml','goccie','bustine')) not null, instructions text, standard integer not null );";
    public static final String CREATE_SCHEDULE = "create table Schedule( therapy integer references therapy(idTherapy) not null on delete cascade on update cascade, time text not null, amount real check(amount>0) not null, primary key(therapy,time) );";
    public static final String CREATE_ASSUMPTION = "create table Assumption( idAssumption integer primary key autoincrement, date text not null, taken integer not null, delay integer check(delay>=0) not null, pain real check(pain in (0,2.5,5,7.5,10)) not null, humor integer check(humor in (1,2,3)) not null, notes text, time text references Schedule(time) not null on delete cascade on update cascade, therapy integer references Schedule(therapy) not null on delete cascade on update cascade );";
    public static final String CREATE_TAG = "create table Tag( idTag text primary key, name text not null, color text not null, batteryLevel text not null, therapy integer references Therapy(idTherapy) on delete set null on update cascade, patient text references Patient(codPatient) on delete set null on update cascade );";


    public DBHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creation of DB
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_OCCASIONAL_MEDICINE);
        db.execSQL(CREATE_THERAPY);
        db.execSQL(CREATE_MEDICINE);
        db.execSQL(CREATE_SCHEDULE);
        db.execSQL(CREATE_ASSUMPTION);
        db.execSQL(CREATE_TAG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
    /* Put here helper methods like inert data and execute query*/


    public long insertUser(User user)
    {

        String crypt=null;
        //inserimento paziente
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues patient = new ContentValues();
        patient.put("codPatient",user.getCode() );

        try {
            crypt=md5(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        patient.put("password", crypt);
        return db.insert("Patient", null, patient);//or db.insertOrThrow("Patient", null, patient);
        //se va a buon fine restituisce l'id altrimenti se non viene salvato nel db restituisce -1
    }
    public long insertOccasionalMedicine(OccasionalMedicine occasionalMedicine, String codUser)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //inserimento farmaco occasionale
        ContentValues o= new ContentValues();
        o.put("name", occasionalMedicine.getName());
        o.put("amount", occasionalMedicine.getAmount());
        o.put("unit", occasionalMedicine.getUnit());
        o.put("date", occasionalMedicine.getDate());
        o.put("time",occasionalMedicine.getTime() );
        o.put("patient", codUser);
        return db.insert("OccasionalMedicine", null, o);
    }

    public long insertTherapy(Therapy therapy, String codUser, Integer idMedicine)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues o= new ContentValues();
        // inserimento nuova terapia
        o.put("medicine", idMedicine);
        o.put("dailyFrequency", therapy.getDailyFrequency());
        o.put("startDate", therapy.getStartDate());
        o.put("duration", therapy.getDuration());
        o.put("dayFrequency", therapy.getDayFrequency());
        o.put("stock",therapy.getStock() );
        o.put("limitStock", therapy.getLimitStock());
        o.put("notificationStock", therapy.isNotice());
        o.put("patient", codUser );
        return db.insert("Therapy", null, o);
    }


    public long insertMedicine(Medicine medicine)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues o= new ContentValues();
        // inserimento farmaco
        o.put("name", medicine.getName());
        o.put("unit", medicine.getUnit());
        o.put("instructions", medicine.getInstructions());
        o.put("standard", medicine.isStandard());
        return db.insert("Medicine", null, o);
    }

    public long insertSchedule(Schedule schedule)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues o= new ContentValues();
        // inserimento orari
        o.put("therapy",schedule.getTherapy() );
        o.put("time", schedule.getTime());
        o.put("amount", schedule.getAmount());
        return db.insert("Schedule", null, o);
    }

    public long insertAssumption(Assumption assumption, Integer idTherapy, String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues o= new ContentValues();
        //inserimento assunzione
        o.put("date", assumption.getDate() );
        o.put("taken", assumption.isTaken());
        o.put("delay", assumption.getDelay());
        o.put("pain", assumption.getPain());
        o.put("humor", assumption.getNotes());
        o.put("notes", assumption.getNotes());
        o.put("time", time );
        o.put("therapy", idTherapy);
        return db.insert("Assumption", null, o);
    }

    public long insertTag(Tag tag)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues o= new ContentValues();
        //inserimento tag
        o.put("idTag", tag.getId());//e' un codice, non autoincrement
        o.put("name", tag.getName());
        o.put("color", tag.getColour());
        o.put("batteryLevel", tag.getBatteryLevel());
        o.put("therapy",tag.getTeraphy() );
        o.put("patient", tag.getUser());
        return db.insert("Tag", null, o);
    }

    public static String md5(String s) throws NoSuchAlgorithmException
    {
        String md5;
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        md5=new BigInteger(1,m.digest()).toString(16);
        return md5;
    }


    public boolean selectTherapiesById(Integer id)
    {
        boolean bool = false;


        Cursor cursor = getReadableDatabase().rawQuery("select * from Therapy where idTherapy = ?", new String[]{String.valueOf(id)});

        if (cursor != null) {
            if (cursor.moveToFirst())
                bool = true;
            cursor.close();
        }
        return bool;
    }





}