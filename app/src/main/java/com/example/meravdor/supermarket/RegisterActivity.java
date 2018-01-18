package com.example.meravdor.supermarket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RESULT_LOAD_IMAGE = 0;
    private EditText etFirstName,etLastName,etPassword,etStreet,etCity,etEmail;
    @Keep
    private String firstname,lastname,password,street,city,email, uri;
    Button bRegister;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static  final int CAMERA_REQUEST_CODE=1;
    private Button pictureButton;
    private Button galleryButton;
    static  ImageView imageToUpload;
    FirebaseStorage storage;
    StorageReference storageReference;
    //    StorageReference mStorage;
    private  Uri filePath;
    String userId;
    private Firebase mRootRef;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Firebase.setAndroidContext(this);
        mRootRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users");
        storage=  FirebaseStorage.getInstance();
        storageReference=storage.getReference();
        ///////////////////////////////////////////
        imageToUpload = (ImageView)findViewById(R.id.imageToUpload);
        pictureButton = (Button) findViewById(R.id.pictureButton);
        galleryButton = (Button) findViewById(R.id.galleryButton);

        pictureButton.setOnClickListener(this);
        galleryButton.setOnClickListener(this);
        //////////////////////////////////////////

        mAuth = FirebaseAuth.getInstance();
        etFirstName = (EditText) findViewById(R.id.firstname);
        etLastName = (EditText) findViewById(R.id.lastname);
        etPassword = (EditText) findViewById(R.id.password);
        etStreet = (EditText) findViewById(R.id.street);
        etCity = (EditText) findViewById(R.id.city);
        etEmail = (EditText) findViewById(R.id.email);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();

            }

        });
    }
    private  void uploadImage(){
        if (filePath!=null){
            final ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setTitle("uploding...") ;
            progressDialog.show();
            String rand = UUID.randomUUID().toString();
            StorageReference ref=storageReference.child("image"+rand );
            ref.getDownloadUrl();
            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    uri=taskSnapshot.getDownloadUrl().toString();

                    Toast.makeText(RegisterActivity.this, "uploaded  " + uri, Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this,"Filed"+ e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploded"+(int)progress+"%");
                    if((int)progress==100) {

                        Task<AuthResult> authResultTask = mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    firebaseUser = mAuth.getCurrentUser();
                                    userId = firebaseUser.getUid();
                                    databaseReference = FirebaseDatabase.getInstance().getReference("Users");

                                    String id = userId;
                                    User u = new User(firstname, lastname, street, city, password, email,uri);
                                    mRootRef.child(id).setValue(u);

                                    Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                                    startActivity(i);
                                }
                            }
                        });
                    }
                }

            });
        }
        else {
            Task<AuthResult> authResultTask = mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        firebaseUser = mAuth.getCurrentUser();
                        userId = firebaseUser.getUid();
                        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

                        String id = userId;
//                        uri = "https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=0ahUKEwjNx_zs2N_YAhUMKVAKHWFTCscQjRwIBw&url=https%3A%2F%2Fbina.org.il%2F%25D7%259E%25D7%2595%25D7%25A6%25D7%25A8%2F%25D7%25A9%25D7%259C%25D7%2595%25D7%25A9%25D7%2599%25D7%259D-%25D7%25A9%25D7%2599%25D7%25A8%25D7%2599-%25D7%2597%25D7%2592-%25D7%259E%25D7%2595%25D7%25A2%25D7%2593-%25D7%2595%25D7%25A0%25D7%2595%25D7%25A4%25D7%259C%2F&psig=AOvVaw107vJw3XLLfqzxHkeD11WY&ust=1516302423635035";
                        User u = new User(firstname, lastname, street, city, password, email);
                        mRootRef.child(id).setValue(u);
                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(i);
                    }
                }
            });
        }
    }
    public void register(){
        intialize();
        if(!vaildate()){
            Toast.makeText(this,"signup has Failed",Toast.LENGTH_SHORT).show();
        }
        else{
            uploadImage();
        }
    }
    @Keep
    public boolean vaildate(){

        boolean vaild = true;
        if (firstname.isEmpty()||firstname.length()>32){
            etFirstName.setError("Please enter vaild first name");
            vaild = false;
        }
        else if (lastname.isEmpty()||lastname.length()>32){
            etLastName.setError("Please enter vaild last name");
            vaild = false;
        }
        else if(password.length()>32||password.length()<6){
            etPassword.setError("Please enter vaild password");
            vaild = false;
        }
        else if(street.isEmpty()){
            etStreet.setError("Please enter vaild street");
            vaild = false;
        }
        else if(city.isEmpty()){
            etCity.setError("Please enter vaild city");
            vaild = false;
        }
        else if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Please enter vaild E-mail");
            vaild = false;
        }
//        else {



//        }
        return vaild;
    }
    public void intialize(){
        firstname = etFirstName.getText().toString().trim();
        lastname = etLastName.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        street = etStreet.getText().toString().trim();
        city = etCity.getText().toString().trim();
        email = etEmail.getText().toString().trim();
//        uri = uri.trim();


    }
    ///////////////////// func that run, when there is a click.
    public void onClick (View v)
    {
        switch (v.getId()) // cases for specific button that clicked
        {
            case R.id.galleryButton: // choose from gallery
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE );
                break;

            case R.id.pictureButton: // take a picture
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
                break;
        }

    }

    @Override // Activity for intent
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data !=null)
        {
            switch (requestCode) {
                case RESULT_LOAD_IMAGE: // choose from gallery
                    filePath = data.getData();
                    imageToUpload.setImageURI(filePath);
                    String mimeType = getContentResolver().getType(filePath);

//                    Toast.makeText(this,mimeType,Toast.LENGTH_SHORT).show();
                    if (mimeType.endsWith("png")) {
                        Toast.makeText(this, "The file is appropriate", Toast.LENGTH_SHORT).show();
                    }
                    if(mimeType.endsWith("jpeg")){
                        Toast.makeText(this,"The file is appropriate",Toast.LENGTH_SHORT).show();
                    }
                    if(!mimeType.endsWith("png") && !mimeType.endsWith("jpeg")) {
                        Toast.makeText(this,"Please enter vaild File",Toast.LENGTH_SHORT).show();
                    }
                    break;

                case REQUEST_IMAGE_CAPTURE: // take a picture
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                    imageToUpload.setImageBitmap(imageBitmap);
//                    filePath = data.getData();
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG,100,bytes);
                    String path = MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(),imageBitmap,"Title","adding a photo to gallery");
                    filePath = Uri.parse(path);
                    break;
            }
        }
    }



}