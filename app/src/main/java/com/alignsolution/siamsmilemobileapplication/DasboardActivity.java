package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.DasboardListOpportunityAdapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Biz.Claim;
import com.alignsolution.siamsmilemobileapplication.Biz.ClaimDoc;
import com.alignsolution.siamsmilemobileapplication.Biz.ClaimDocMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.ClaimMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Complain;
import com.alignsolution.siamsmilemobileapplication.Biz.ComplainMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Content;
import com.alignsolution.siamsmilemobileapplication.Biz.ContentMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.News;
import com.alignsolution.siamsmilemobileapplication.Biz.NewsMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Opportunity;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityProduct;
import com.alignsolution.siamsmilemobileapplication.Biz.OppurtunityProduct_MGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Payment;
import com.alignsolution.siamsmilemobileapplication.Biz.PaymentMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Policy;
import com.alignsolution.siamsmilemobileapplication.Biz.PolicyMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.ProductContact;
import com.alignsolution.siamsmilemobileapplication.Biz.ProductContactMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.ProductItem;
import com.alignsolution.siamsmilemobileapplication.Biz.ProductItemMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.ProductPromotion;
import com.alignsolution.siamsmilemobileapplication.Biz.ProductPromotionMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.ProductSales;
import com.alignsolution.siamsmilemobileapplication.Biz.ProductSalesMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Task;
import com.alignsolution.siamsmilemobileapplication.Biz.TaskMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Users;
import com.alignsolution.siamsmilemobileapplication.Biz.UsersMGR;

import java.util.ArrayList;

/**
 * Created by aligndev on 4/4/2017.
 */

public class DasboardActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        try {

            SetHeader("Dasboard", false, false);
            SetMenu();
            SetData();

        } catch (Exception e) {
            Log.i("Err Log", "DasboardActivity : " + Log.getStackTraceString(e));
        }
    }

    public void SetData() {

        listView = (ListView) findViewById(R.id.opportunitylist);
        ArrayList<Opportunity> oOpportunity = dataMGR.SelectData(this);
        DasboardListOpportunityAdapter adap = new DasboardListOpportunityAdapter(DasboardActivity.this, oOpportunity);
        listView.setAdapter(adap);

//        InsertClaim();
//        InsertClaimDoc();
//        InsertComplain();
//        InsertContent();
//        InsertNews();
//        InsertOpportunity();
//        InsertOpportunityProduct();
//        InsertPayment();
//        InsertPolicy();
//        InsertProductContact();
//        InsertProductPromotion();
//        InsertTask();
//        InsertProductSales();
//        InsertUsers();
//        InsertProductItem();

        DeleteClaim();
        DeleteClaimDoc();
        DeleteComplain();
        DeleteContent();
        DeleteNews();
        DeleteOpportunity();
        DeleteOpportunityProduct();
        DeletePayment();
        DeletePolicy();
        DeleteProductContract();
        DeleteProductPromotion();
        DeleteTask();
        DeleteProductSale();
        DeleteUsers();
        DeleteProductItem();






    }

    public void selectItem(int position) {
        menuMGR.CustomerMenuSelect(position, this);
    }

    public void SetMenu() {


        //Close and open sideBar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MenuAdapter menuAdapter = new MenuAdapter(DasboardActivity.this,
                menuMGR.MenuText(), menuMGR.MenuImg());
        MenuList = (ListView) findViewById(R.id.list);
        MenuList.setAdapter(menuAdapter);
        MenuList.setOnItemClickListener(this);


    }

    public void SetHeader(String TextTitle, boolean ShowAddButton, boolean ShowNotify) {

        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_header);

        TextView Title = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.txtTitle);
        Title.setText(TextTitle);

        if (!ShowAddButton) {
            ImageButton btnAdd = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.btnAdd);
            btnAdd.setVisibility(View.GONE);
        }

        if (!ShowNotify) {

            ImageView imgNotify = (ImageView) getSupportActionBar().getCustomView().findViewById(R.id.imgnotify);
            imgNotify.setVisibility(View.GONE);
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,planets[position]+ "   was selected ", Toast.LENGTH_SHORT).show();

        selectItem(position);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void  InsertClaim() {

        ClaimMGR claimMGR = new ClaimMGR();
        Claim claim = new Claim();
        boolean result;
        ArrayList<Claim> ClaimList;

        claim.setClaimCode("1");
        claim.setClaimType("2");
        claim.setAccidentDate("3");
        claim.setHospital("4");
        claim.setHospitalInDate("5");
        claim.setHospitalOutDate("6");
        claim.setProvince("7");
        claim.setDescription("8");
        claim.setChiefCormplain("9");
        claim.setJudge("10");
        claim.setBankAccName("11");
        claim.setBankAccNo("12");
        claim.setBankAccType("13");
        claim.setBank("14");
        claim.setBankBranch("15");
        claim.setAuthorizeDesc("16");
        claim.setAuthorizeSign("17");
        claim.setAuthorizeDate("18");
        claim.setSubmitDate("19");
        claim.setStatus("20");
        claim.setCreatedOn("21");
        claim.setModifiedOn("22");
        claim.setSyncDate("23");
        claim.setSyncStatus("24");

        result = claimMGR.InsertData(claim, getBaseContext());
        ClaimList = claimMGR.SelectData(getBaseContext());

        Log.i("Opp_InsertData", "Show_Result_Claim = " + String.valueOf(result));
        //Log.i("Claim_SelectData","Show_ClaimList"+String.valueOf(ClaimList.get(1).getHospital()));
        Log.i("Claim_SelectData", "Show_ClaimList = " + String.valueOf(ClaimList.size()));
    }

    public void  InsertClaimDoc(){

        ClaimDocMGR claimDocMGR =new ClaimDocMGR();
        ClaimDoc claimDoc = new ClaimDoc();
        boolean result ;
        ArrayList<ClaimDoc> ClaimDocList;

        claimDoc.setAppId("1");
        claimDoc.setClaimNo("2");
        claimDoc.setInvoiceTotal("3");
        claimDoc.setInvoiceDocType("4");
        claimDoc.setMedicalCert("10");
        claimDoc.setMedicalCertDocType("11");
        claimDoc.setCreatedOn("12");
        claimDoc.setModifiedOn("13");
        claimDoc.setSyncDate("14");
        claimDoc.setSyncStatus("15");
        result = claimDocMGR.InsertData(claimDoc,getBaseContext());
        ClaimDocList = claimDocMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ClaimDoc = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ClaimDocList = "+String.valueOf(ClaimDocList.size()));

    }

    public void  InsertComplain(){

        ComplainMGR ComplainMGR =new ComplainMGR();
        Complain complain = new Complain();
        boolean result ;
        ArrayList<Complain> ComplainList;

        complain.setComplainNo("");
        complain.setComplainType("");
        complain.setDescription("");
        complain.setCreatedOn("");
        complain.setModifiedOn("");
        complain.setSyncDate("");
        complain.setSyncStatus("");

        result = ComplainMGR.InsertData(complain,getBaseContext());
        ComplainList = ComplainMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Complain = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ComplainList = "+String.valueOf(ComplainList.size()));

    }

    public void  InsertContent(){

        ContentMGR contentMGR =new ContentMGR();
        Content content = new Content();
        boolean result ;
        ArrayList<Content> ContentList;

        content.setContentNo("test2");
        content.setTitle("2");
        content.setDescription("2");
        content.setPicture("2");
        content.setCreatedOn("2");
        content.setModifiedOn("2");
        content.setSyncDate("2");
        content.setSyncStatus("2");

        result = contentMGR.InsertData(content,getBaseContext());
        ContentList = contentMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Content = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ContentList = "+String.valueOf(ContentList.size()));

    }

    public void  InsertNews(){

        NewsMGR newsMGR =new NewsMGR();
        News news = new News();
        boolean result ;
        ArrayList<News> NewsList;

        news.setNewsNo("test1");
        news.setURL("1");
        news.setTitle("1");
        news.setDescription("1");
        news.setPicture("1");
        news.setCreatedOn("1");
        news.setModifiedOn("1");
        news.setStartDate("1");
        news.setEndDate("1");
        news.setSyncDate("1");
        news.setSyncStatus("1");

        result = newsMGR.InsertData(news,getBaseContext());
        NewsList = newsMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_News = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_NewsList = "+String.valueOf(NewsList.size()));
    }

    public void  InsertOpportunity(){


        OpportunityMGR opportunityMGR =new OpportunityMGR();
        Opportunity opportunity = new Opportunity();
        boolean result ;
        ArrayList<Opportunity> OpportunityList;

        opportunity.setOpportunityNo("1");
        opportunity.setFirstName("1");
        opportunity.setLastName("1");
        opportunity.setCardNo("1");
        opportunity.setPhoneNumber1("1");
        opportunity.setPhoneNumber2("1");
        opportunity.setEmail("1");
        opportunity.setLineId("1");
        opportunity.setAddress("1");
        opportunity.setProvince("1");
        opportunity.setRemark("1");
        opportunity.setPicture("1");
        opportunity.setGPSLat("1");
        opportunity.setGPSLong("1");
        opportunity.setOpportunityType("1");
        opportunity.setCause("1");
        opportunity.setPictureType("1");
        opportunity.setInstitute("1");
        opportunity.setPlace("1");
        opportunity.setDistrict("1");
        opportunity.setSubDistrict("1");
        opportunity.setProvince("1");
        opportunity.setAgentNo("1");
        opportunity.setCreatedOn("1");
        opportunity.setModifiedOn("1");
        opportunity.setSyncDate("1");
        opportunity.setSyncStatus("1");

        result = opportunityMGR.InsertData(opportunity,getBaseContext());
        OpportunityList = opportunityMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Opportunity = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_OpportunityList = "+String.valueOf(OpportunityList.size()));
    }

    public void  InsertOpportunityProduct(){

        OppurtunityProduct_MGR oppurunityProduct_mgr =new OppurtunityProduct_MGR();
        OpportunityProduct opportunityProduct = new OpportunityProduct();
        boolean result ;
        ArrayList<OpportunityProduct> OpportunityProductList;
        opportunityProduct.setOpportunityProductNo("");
        opportunityProduct.setProductNo("");
        opportunityProduct.setProductType("");
        opportunityProduct.setInsureType("");
        opportunityProduct.setPercent("");
        opportunityProduct.setPicture("");
        opportunityProduct.setCreatedOn("");
        opportunityProduct.setModifiedOn("");
        opportunityProduct.setSyncDate("");
        opportunityProduct.setSyncStatus("");

        result = oppurunityProduct_mgr.InsertData(opportunityProduct,getBaseContext());
        OpportunityProductList = oppurunityProduct_mgr.SelectDataPro(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_OpportunityProduct = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_OpportunityProductList = "+String.valueOf(OpportunityProductList.size()));

    }

    public void  InsertPayment(){

        PaymentMGR paymentMGR =new PaymentMGR();
        Payment payment = new Payment();
        boolean result ;
        ArrayList<Payment> PaymentList;
        payment.setPaymentNo("");
        payment.setPaymentType("");
        payment.setPremium("");
        payment.setAgentNo("");
        payment.setInvoiceNo("");
        payment.setCreatedOn("");
        payment.setModifiedOn("");
        payment.setSyncDate("");
        payment.setSyncStatus("");

        result = paymentMGR.InsertData(payment,getBaseContext());
        PaymentList = paymentMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Payment = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_PaymentList = "+String.valueOf(PaymentList.size()));
    }

    public void  InsertPolicy(){

        PolicyMGR policyMGR =new PolicyMGR();
        Policy policy = new Policy();
        boolean result ;
        ArrayList<Policy> PolicyList;
        policy.setAppId("");
        policy.setPolicyStatus("");
        policy.setStatus("");
        policy.setCompany("");
        policy.setPlan("");
        policy.setStartDate("");
        policy.setEndDate("");
        policy.setFirstName("");
        policy.setLastName("");
        policy.setMobileNo("");
        policy.setProvince("");
        policy.setCardNo("");
        policy.setPolicyCardNo("");
        policy.setPayer("");
        policy.setBirthDate("");
        policy.setAge("");
        policy.setAgeOnInsure("");
        policy.setAgeInsure("");
        policy.setAgentNo("");
        policy.setAgentName("");
        policy.setBranch("");
        policy.setCliamNo("");
        policy.setCreatedOn("");
        policy.setModifiedOn("");
        policy.setSyncDate("");
        policy.setSyncStatus("");

        result = policyMGR.InsertData(policy,getBaseContext());
        PolicyList = policyMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Policy = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_PolicyList = "+String.valueOf(PolicyList.size()));
    }

    public void  InsertProductContact(){

        ProductContactMGR productContactMGR =new ProductContactMGR();
        ProductContact productContact = new ProductContact();
        boolean result ;
        ArrayList<ProductContact> ProductConctList;

        productContact.setUserId("");
        productContact.setAgentCallDate("");
        productContact.setPhoneNumber("");
        productContact.setCreatedOn("");
        productContact.setModifiedOn("");
        productContact.setSyncDate("");
        productContact.setSyncStatus("");

        result = productContactMGR.InsertData(productContact,getBaseContext());
        ProductConctList = productContactMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ProductContact = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ProductContactList = "+String.valueOf(ProductConctList.size()));
    }

    public void  InsertProductPromotion(){


        ProductPromotionMGR productPromotionMGR =new ProductPromotionMGR();
        ProductPromotion productPromotion = new ProductPromotion();
        boolean result ;
        ArrayList<ProductPromotion> ProductPromotionList;

        productPromotion.setProductNo("");
        productPromotion.setProductName("");
        productPromotion.setProductItem("");
        productPromotion.setDescription("");
        productPromotion.setProductType("");
        productPromotion.setBenefit("");
        productPromotion.setBirthDate("");
        productPromotion.setCardNo("");
        productPromotion.setCreatedOn("");
        productPromotion.setModifiedOn("");
        productPromotion.setSyncDate("");
        productPromotion.setSyncStatus("");

        result = productPromotionMGR.InsertData(productPromotion,getBaseContext());
        ProductPromotionList = productPromotionMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ProductPromotion = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ProductPromotionList = "+String.valueOf(ProductPromotionList.size()));
    }

    public void  InsertProductSales(){
        ProductSalesMGR productSalesMGR =new ProductSalesMGR();
        ProductSales productSales = new ProductSales();
        boolean result ;
        ArrayList<ProductSales> ProductSalesList;

        productSales.setProductSalesNo("");
        productSales.setAppId("");
        productSales.setProductNo("");
        productSales.setPolicyMonth("");
        productSales.setPolicyYear("");
        productSales.setScreenDate("");
        productSales.setRelationCustomer("");
        productSales.setCardNo("");
        productSales.setCustmerName("");
        productSales.setCareer("");
        productSales.setCareerLavel("");
        productSales.setPhoneNumber("");
        productSales.setEmail("");
        productSales.setAddress("");
        productSales.setPaymentType("");
        productSales.setPremium("");
        productSales.setAgentNo("");
        productSales.setInvoiceNo("");
        productSales.setCreatedOn("");
        productSales.setModifiedOn("");
        productSales.setSyncDate("");
        productSales.setSyncStatus("");

        result = productSalesMGR.InsertData(productSales,getBaseContext());
        ProductSalesList = productSalesMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ProductSales = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ProductSalesList = "+String.valueOf(ProductSalesList.size()));

    }

    public void  InsertTask(){

        TaskMGR taskMGR =new TaskMGR();
        Task task = new Task();
        boolean result ;
        ArrayList<Task> TaskList;

        task.setTaskNo("");
        task.setTitle("");
        task.setDescription("");
        task.setAgentNo("");
        task.setCreatedOn("");
        task.setModifiedOn("");
        task.setSyncDate("");
        task.setSyncStatus("");

        result = taskMGR.InsertData(task,getBaseContext());
        TaskList = taskMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Task = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_TaskList = "+String.valueOf(TaskList.size()));
    }

    public void  InsertUsers(){
        UsersMGR usersMGR =new UsersMGR();
        Users users = new Users();
        boolean result ;
        ArrayList<Users> UsersList;
        users.setUserID("");
        users.setUserLogin("");
        users.setPassword("");
        users.setFirstName("");
        users.setLastName("");
        users.setCardNo("");
        users.setBirthDate("");
        users.setEmail("");
        users.setPhoneNumber1("");
        users.setPhoneNumber2("");
        users.setHomeAddress1("");
        users.setWorkAddress2("");
        users.setHomeAddress2("");
        users.setWorkAddress1("");
        users.setHomeSubdistrict("");
        users.setHomeDistrict("");
        users.setHomeZipCode("");
        users.setWorkSubdistrict("");
        users.setWorkDistrict("");
        users.setWorkZipCode("");
        users.setAgentSubdistrict("");
        users.setAgentDistrict("");
        users.setAgentProvice("");
        users.setUserType("");
        users.setPicture("");
        users.setCreatedOn("");
        users.setModifiedOn("");
        users.setSyncDate("");
        users.setSyncStatus("");

        result = usersMGR.InsertData(users,getBaseContext());
        UsersList = usersMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Users = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_UsersList = "+String.valueOf(UsersList.size()));

    }

    public void  InsertProductItem(){
        ProductItemMGR productItemMGR =new ProductItemMGR();
        ProductItem productItem = new ProductItem();
        boolean result ;
        ArrayList<ProductItem> ProductItemList;
        productItem.setProductItemNo("");
        productItem.setProductItemName("");
        productItem.setProductNo("");
        productItem.setCreatedOn("");
        productItem.setModifiedOn("");
        productItem.setSyncDate("");
        productItem.setSyncStatus("");

        result = productItemMGR.InsertData(productItem,getBaseContext());
        ProductItemList = productItemMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ProductItem = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ProductItemList = "+String.valueOf(ProductItemList.size()));

    }

    public  void UpdateClaim(){

        ClaimMGR claimMGR =new ClaimMGR();
        Claim claim = new Claim();
        boolean result ;
        ArrayList<Claim> ClaimList ;
        ClaimList = claimMGR.SelectData(getBaseContext());
        claim = ClaimList.get(0);
        Log.i("Opp_UpDateData"," Show RowId = "+claim.getRowId());
        //claim.setRowId("");
        claim.setClaimCode("TestDataClaim");
        claim.setClaimType("444444444");
        claim.setAccidentDate("c");
        claim.setHospital("e");
        claim.setHospitalInDate("f");
        claim.setHospitalOutDate("d");
        claim.setProvince("s");
        claim.setDescription("f");
        claim.setChiefCormplain("g");
        claim.setJudge("j");
        claim.setBankAccName("j");
        claim.setBankAccNo("j");
        claim.setBankAccType("j");
        claim.setBank("j");
        claim.setBankBranch("j");
        claim.setAuthorizeDesc("j");
        claim.setAuthorizeSign("j");
        claim.setAuthorizeDate("j");
        claim.setSubmitDate("j");
        claim.setStatus("j");
        claim.setCreatedOn("j");
        claim.setModifiedOn("j");
        claim.setSyncDate("k");
        claim.setSyncStatus("k");

        result = claimMGR.UpdateData(claim,getBaseContext());
        ClaimList = claimMGR.SelectData(getBaseContext());
        Log.i("Opp_UpDateData","Show_Result_Claim = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ClaimList = "+String.valueOf(ClaimList.size()));
        Log.d("Test Data", " Fiend ClaimCode Value = "+claim.getClaimCode());
        //Log.i("Claim_SelectData","Show_ClaimList"+String.valueOf(ClaimList.get(0).getHospital()));
//        Log.i("Claim_SelectData","Show_ClaimList_Recode 0 = "+String.valueOf(ClaimList.get(0).getClaimCode()));
//        Log.i("Claim_SelectData","Show_ClaimList_Recode 1 = "+String.valueOf(ClaimList.get(1).getClaimCode()));
    }

    public  void  UpdateClaimDoc(){


        ClaimDocMGR claimDocMGR =new ClaimDocMGR();
        ClaimDoc claimDoc = new ClaimDoc();
        boolean result ;
        ArrayList<ClaimDoc> ClaimDocList;

        claimDoc.setAppId("thailand");
        claimDoc.setClaimNo("12");
        claimDoc.setInvoiceTotal("12");
        claimDoc.setInvoiceDocType("12");
        claimDoc.setMedicalCert("12");
        claimDoc.setMedicalCertDocType("12");
        claimDoc.setCreatedOn("12");
        claimDoc.setModifiedOn("12");
        claimDoc.setSyncDate("12");
        claimDoc.setSyncStatus("12");
        result = claimDocMGR.UpdateData(claimDoc,getBaseContext());
        ClaimDocList = claimDocMGR.SelectData(getBaseContext());
        Log.i("Opp_UpDateData","Show_Result_ClaimDoc = "+String.valueOf(result));
        Log.i("ClaimDoc_SelectData","Show_ClaimDocList = "+String.valueOf(ClaimDocList.size()));
        Log.d("Test Data", " Fiend AppId Value = "+claimDoc.getAppId());
        Log.i("ClaimDoc_SelectData","Show_ClaimDocList_Recode 0 = "+String.valueOf(ClaimDocList.get(0).getAppId()));
        Log.i("ClaimDoc_SelectData","Show_ClaimDocList_Recode 1 = "+String.valueOf(ClaimDocList.get(1).getAppId()));
    }

    public  void  UpdateComplain(){

        ComplainMGR ComplainMGR =new ComplainMGR();
        Complain complain = new Complain();
        boolean result ;
        ArrayList<Complain> ComplainList;

        complain.setComplainNo("test1");
        complain.setComplainType("11");
        complain.setDescription("11");
        complain.setCreatedOn("11");
        complain.setModifiedOn("11");
        complain.setSyncDate("11");
        complain.setSyncStatus("11");

        result = ComplainMGR.UpdateData(complain,getBaseContext());
        ComplainList = ComplainMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Complain = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ComplainList = "+String.valueOf(ComplainList.size()));

        Log.d("Test Data", " Fiend ComplainNo Value = "+complain.getComplainNo());
        Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 0 = "+String.valueOf(ComplainList.get(0).getComplainNo()));
        // Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 1 = "+String.valueOf(ComplainList.get(1).getComplainNo()));
    }

    public void  UpdateContent(){

//        ContentMGR contentMGR =new ContentMGR();
//        Content content = new Content();
//
//        boolean result ;
//        ArrayList<Content> ContentList = new ArrayList<Content>();
//        ArrayList<Content> ContentList2 = new ArrayList<Content>();
//        ContentList = contentMGR.SelectData(getBaseContext());
//        content = ContentList.get(1);
//        Log.i("Opp_UpDateData"," Show RowId = "+content.getRowId());
//
//
//        //content.setRowId("1");
//        content.setContentNo("test1");
//        content.setTitle("2");
//        content.setDescription("22");
//        content.setPicture("2");
//        content.setCreatedOn("2");
//        content.setModifiedOn("2");
//        content.setSyncDate("2");
//        content.setSyncStatus("2");
//
//        result = contentMGR.UpdateData(content,getBaseContext());
//        ContentList2 = contentMGR.SelectData(getBaseContext());
//
//        Log.i("Opp_InsertData","Show_Result_Content = "+String.valueOf(result));
//        Log.i("Claim_SelectData","Show_ContentList = "+String.valueOf(ContentList2.size()));
//        //Log.d("Test Data", " Fiend Value = "+Content.getContentNo());
//        Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 0 = "+String.valueOf(ContentList2.get(0).getContentNo()));
//        Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 1 = "+String.valueOf(ContentList2.get(1).getContentNo()));


        ContentMGR contentMGR =new ContentMGR();
        Content content = new Content();

        boolean result ;
        ArrayList<Content> ContentList = new ArrayList<Content>();
        ArrayList<Content> ContentList2 = new ArrayList<Content>();


        ContentList = contentMGR.SelectData(getBaseContext());
        content = ContentList.get(0);

        for (int i=0;i<ContentList.size();i++){
            Log.i("Opp_UpDateData","Show Data"+ContentList.get(i).getRowId());
            Log.i("Opp_UpDateData"," Show RowId = "+content.getRowId());

        }

        //content.setRowId("1");
        content.setContentNo("test1");
        content.setTitle("2");
        content.setDescription("22");
        content.setPicture("2");
        content.setCreatedOn("2");
        content.setModifiedOn("2");
        content.setSyncDate("2");
        content.setSyncStatus("2");

        result = contentMGR.UpdateData(content,getBaseContext());
        ContentList2 = contentMGR.SelectData(getBaseContext());

        Log.i("Opp_InsertData","Show_Result_Content = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ContentList = "+String.valueOf(ContentList2.size()));
        //Log.d("Test Data", " Fiend Value = "+Content.getContentNo());
        Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 0 = "+String.valueOf(ContentList2.get(0).getContentNo()));
        //Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 1 = "+String.valueOf(ContentList2.get(1).getContentNo()));

    }

    public void  UpdateNews(){

        NewsMGR newsMGR =new NewsMGR();
        News news = new News();
        boolean result ;
        ArrayList<News> NewsList;
//        NewsList = newsMGR.SelectData(getBaseContext());
//        news = NewsList.get(1);
//        Log.i("Opp_UpDateData"," Show RowId = "+news.getRowId());

        news.setNewsNo("test1");
        news.setURL("1");
        news.setTitle("1");
        news.setDescription("1");
        news.setPicture("1");
        news.setCreatedOn("1");
        news.setModifiedOn("1");
        news.setStartDate("1");
        news.setEndDate("1");
        news.setSyncDate("1");
        news.setSyncStatus("1");


        result = newsMGR.InsertData(news,getBaseContext());
        NewsList = newsMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_News = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_NewsList = "+String.valueOf(NewsList.size()));

    }

    public void  UpdateOpportunity(){

        OpportunityMGR opportunityMGR =new OpportunityMGR();
        Opportunity opportunity = new Opportunity();
        boolean result ;
        ArrayList<Opportunity> OpportunityList;

        opportunity.setOpportunityNo("");
        opportunity.setFirstName("");
        opportunity.setLastName("");
        opportunity.setCardNo("");
        opportunity.setPhoneNumber1("");
        opportunity.setPhoneNumber2("");
        opportunity.setEmail("");
        opportunity.setLineId("");
        opportunity.setAddress("");
        opportunity.setProvince("");
        opportunity.setRemark("");
        opportunity.setPicture("");
        opportunity.setGPSLat("");
        opportunity.setGPSLong("");
        opportunity.setOpportunityType("");
        opportunity.setCause("");
        opportunity.setPictureType("");
        opportunity.setInstitute("");
        opportunity.setPlace("");
        opportunity.setDistrict("");
        opportunity.setSubDistrict("");
        opportunity.setProvince("");
        opportunity.setAgentNo("");
        opportunity.setCreatedOn("");
        opportunity.setModifiedOn("");
        opportunity.setSyncDate("");
        opportunity.setSyncStatus("");

        result = opportunityMGR.UpdateData(opportunity,getBaseContext());
        OpportunityList = opportunityMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Opportunity = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_OpportunityList = "+String.valueOf(OpportunityList.size()));

    }

    public void UpdateOpportunityProduct(){

        OppurtunityProduct_MGR oppurunityProduct_mgr =new OppurtunityProduct_MGR();
        OpportunityProduct opportunityProduct = new OpportunityProduct();
        boolean result ;
        ArrayList<OpportunityProduct> OpportunityProductList;
        opportunityProduct.setOpportunityProductNo("");
        opportunityProduct.setProductNo("");
        opportunityProduct.setProductType("");
        opportunityProduct.setInsureType("");
        opportunityProduct.setPercent("");
        opportunityProduct.setPicture("");
        opportunityProduct.setCreatedOn("");
        opportunityProduct.setModifiedOn("");
        opportunityProduct.setSyncDate("");
        opportunityProduct.setSyncStatus("");

        result = oppurunityProduct_mgr.UpdateData(opportunityProduct,getBaseContext());
        OpportunityProductList = oppurunityProduct_mgr.SelectDataPro(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_OpportunityProduct = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_OpportunityProductList = "+String.valueOf(OpportunityProductList.size()));

    }

    public void UpdatePayment(){

        PaymentMGR paymentMGR =new PaymentMGR();
        Payment payment = new Payment();
        boolean result ;
        ArrayList<Payment> PaymentList;
        payment.setPaymentNo("");
        payment.setPaymentType("");
        payment.setPremium("");
        payment.setAgentNo("");
        payment.setInvoiceNo("");
        payment.setCreatedOn("");
        payment.setModifiedOn("");
        payment.setSyncDate("");
        payment.setSyncStatus("");

        result = paymentMGR.UpdateData(payment,getBaseContext());
        PaymentList = paymentMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Payment = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_PaymentList = "+String.valueOf(PaymentList.size()));

    }

    public void UpdatePolicy(){


        PolicyMGR policyMGR =new PolicyMGR();
        Policy policy = new Policy();
        boolean result ;
        ArrayList<Policy> PolicyList;
//
//        PolicyList = policyMGR.SelectData(getBaseContext());
//        policy = PolicyList.get(0);
//        Log.i("Opp_UpDateData"," Show RowId = "+policy.getRowId());


        policy.setAppId("");
        policy.setPolicyStatus("");
        policy.setStatus("");
        policy.setCompany("");
        policy.setPlan("");
        policy.setStartDate("");
        policy.setEndDate("");
        policy.setFirstName("");
        policy.setLastName("");
        policy.setMobileNo("");
        policy.setProvince("");
        policy.setCardNo("");
        policy.setPolicyCardNo("");
        policy.setPayer("");
        policy.setBirthDate("");
        policy.setAge("");
        policy.setAgeOnInsure("");
        policy.setAgeInsure("");
        policy.setAgentNo("");
        policy.setAgentName("");
        policy.setBranch("");
        policy.setCliamNo("");
        policy.setCreatedOn("");
        policy.setModifiedOn("");
        policy.setSyncDate("");
        policy.setSyncStatus("");

        result = policyMGR.InsertData(policy,getBaseContext());
        PolicyList = policyMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Policy = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_PolicyList = "+String.valueOf(PolicyList.size()));

    }

    public void UpdateProductContract(){

        ProductContactMGR productContactMGR =new ProductContactMGR();
        ProductContact productContact = new ProductContact();
        boolean result ;
        ArrayList<ProductContact> ProductConctList;

        ProductConctList = productContactMGR.SelectData(getBaseContext());
        productContact = ProductConctList.get(0);
        Log.i("Opp_UpDateData"," Show RowId = "+productContact.getRowId());

        productContact.setUserId("");
        productContact.setAgentCallDate("");
        productContact.setPhoneNumber("");
        productContact.setCreatedOn("");
        productContact.setModifiedOn("");
        productContact.setSyncDate("");
        productContact.setSyncStatus("");

        result = productContactMGR.UpdateData(productContact,getBaseContext());
        ProductConctList = productContactMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ProductContact = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ProductContactList = "+String.valueOf(ProductConctList.size()));
    }

    public void UpdateProductPromotion(){

        ProductPromotionMGR productPromotionMGR =new ProductPromotionMGR();
        ProductPromotion productPromotion = new ProductPromotion();
        boolean result ;
        ArrayList<ProductPromotion> ProductPromotionList;

        productPromotion.setProductNo("");
        productPromotion.setProductName("");
        productPromotion.setProductItem("");
        productPromotion.setDescription("");
        productPromotion.setProductType("");
        productPromotion.setBenefit("");
        productPromotion.setBirthDate("");
        productPromotion.setCardNo("");
        productPromotion.setCreatedOn("");
        productPromotion.setModifiedOn("");
        productPromotion.setSyncDate("");
        productPromotion.setSyncStatus("");

        result = productPromotionMGR.UpdateData(productPromotion,getBaseContext());
        ProductPromotionList = productPromotionMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ProductPromotion = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ProductPromotionList = "+String.valueOf(ProductPromotionList.size()));


    }

    public void UpdateProductSale(){

        ProductSalesMGR productSalesMGR =new ProductSalesMGR();
        ProductSales productSales = new ProductSales();
        boolean result ;
        ArrayList<ProductSales> ProductSalesList;

        productSales.setProductSalesNo("");
        productSales.setAppId("");
        productSales.setProductNo("");
        productSales.setPolicyMonth("");
        productSales.setPolicyYear("");
        productSales.setScreenDate("");
        productSales.setRelationCustomer("");
        productSales.setCardNo("");
        productSales.setCustmerName("");
        productSales.setCareer("");
        productSales.setCareerLavel("");
        productSales.setPhoneNumber("");
        productSales.setEmail("");
        productSales.setAddress("");
        productSales.setPaymentType("");
        productSales.setPremium("");
        productSales.setAgentNo("");
        productSales.setInvoiceNo("");
        productSales.setCreatedOn("");
        productSales.setModifiedOn("");
        productSales.setSyncDate("");
        productSales.setSyncStatus("");

        result = productSalesMGR.UpdateData(productSales,getBaseContext());
        ProductSalesList = productSalesMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ProductSales = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ProductSalesList = "+String.valueOf(ProductSalesList.size()));

    }

    public void UpdateTask(){

        TaskMGR taskMGR =new TaskMGR();
        Task task = new Task();
        boolean result ;
        ArrayList<Task> TaskList;

        task.setTaskNo("");
        task.setTitle("");
        task.setDescription("");
        task.setAgentNo("");
        task.setCreatedOn("");
        task.setModifiedOn("");
        task.setSyncDate("");
        task.setSyncStatus("");

        result = taskMGR.UpdateData(task,getBaseContext());
        TaskList = taskMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Task = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_TaskList = "+String.valueOf(TaskList.size()));

    }

    public void UpdateUsers(){

        UsersMGR usersMGR =new UsersMGR();
        Users users = new Users();
        boolean result ;
        ArrayList<Users> UsersList;
        users.setUserID("");
        users.setUserLogin("");
        users.setPassword("");
        users.setFirstName("");
        users.setLastName("");
        users.setCardNo("");
        users.setBirthDate("");
        users.setEmail("");
        users.setPhoneNumber1("");
        users.setPhoneNumber2("");
        users.setHomeAddress1("");
        users.setWorkAddress2("");
        users.setHomeAddress2("");
        users.setWorkAddress1("");
        users.setHomeSubdistrict("");
        users.setHomeDistrict("");
        users.setHomeZipCode("");
        users.setWorkSubdistrict("");
        users.setWorkDistrict("");
        users.setWorkZipCode("");
        users.setAgentSubdistrict("");
        users.setAgentDistrict("");
        users.setAgentProvice("");
        users.setUserType("");
        users.setPicture("");
        users.setCreatedOn("");
        users.setModifiedOn("");
        users.setSyncDate("");
        users.setSyncStatus("");

        result = usersMGR.UpdateData(users,getBaseContext());
        UsersList = usersMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_Users = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_UsersList = "+String.valueOf(UsersList.size()));

    }

    public void UpdateProductItem(){

        ProductItemMGR productItemMGR =new ProductItemMGR();
        ProductItem productItem = new ProductItem();
        boolean result ;
        ArrayList<ProductItem> ProductItemList;
        productItem.setProductItemNo("");
        productItem.setProductItemName("");
        productItem.setProductNo("");
        productItem.setCreatedOn("");
        productItem.setModifiedOn("");
        productItem.setSyncDate("");
        productItem.setSyncStatus("");

        result = productItemMGR.UpdateData(productItem,getBaseContext());
        ProductItemList = productItemMGR.SelectData(getBaseContext());
        Log.i("Opp_InsertData","Show_Result_ProductItem = "+String.valueOf(result));
        Log.i("Claim_SelectData","Show_ProductItemList = "+String.valueOf(ProductItemList.size()));


    }

    public  void  DeleteClaim(){
        ClaimMGR claimMGR =new ClaimMGR();
        Claim claim = new Claim();
        boolean result ;
        ArrayList<Claim> ClaimList ;
//        ClaimList = claimMGR.SelectData(getBaseContext());
//        claim = ClaimList.get(0);
//        Log.i("Opp_UpDateData"," Show RowId = "+claim.getRowId());
        //claim.setRowId("");
        claim.getClaimCode();
        claim.getClaimType();
        claim.getAccidentDate();
        claim.getHospital();
        claim.getHospitalInDate();
        claim.getHospitalOutDate();
        claim.getProvince();
        claim.getDescription();
        claim.getChiefCormplain();
        claim.getJudge();
        claim.getBankAccName();
        claim.getBankAccNo();
        claim.getBankAccType();
        claim.getBank();
        claim.getBankBranch();
        claim.getAuthorizeDesc();
        claim.getAuthorizeSign();
        claim.getAuthorizeDate();
        claim.getSubmitDate();
        claim.getStatus();
        claim.getCreatedOn();
        claim.getModifiedOn();
        claim.getSyncDate();
        claim.getSyncStatus();

        result = claimMGR.DeleteData(claim,getBaseContext());
        ClaimList = claimMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_Claim = "+String.valueOf(result));
        Log.i("SelectData","Show_ClaimList = "+String.valueOf(ClaimList.size()));
        Log.d("Test Data", " Fiend ClaimCode Value = "+claim.getClaimCode());
        // Log.i("SelectData","Show "+String.valueOf(ClaimList.get(0).getAppId()));

    }

    public  void  DeleteClaimDoc(){
        ClaimDocMGR claimDocMGR =new ClaimDocMGR();
        ClaimDoc claimDoc = new ClaimDoc();
        boolean result ;
        ArrayList<ClaimDoc> ClaimDocList;

        claimDoc.getAppId();
        claimDoc.getClaimNo();
        claimDoc.getInvoiceTotal();
        claimDoc.getInvoiceDocType();
        claimDoc.getMedicalCert();
        claimDoc.getMedicalCertDocType();
        claimDoc.getCreatedOn();
        claimDoc.getModifiedOn();
        claimDoc.getSyncDate();
        claimDoc.getSyncStatus();
        result = claimDocMGR.DeleteData(claimDoc,getBaseContext());
        ClaimDocList = claimDocMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_ClaimDoc = "+String.valueOf(result));
        Log.i("SelectData","Show_ClaimDocList = "+String.valueOf(ClaimDocList.size()));
        Log.d("Test Data", " Fiend claimDoc Value = "+claimDoc.getAppId());
        // Log.i("SelectData","Show "+String.valueOf(ClaimDocList.get(0).getAppId()));

    }

    public  void  DeleteComplain(){

        ComplainMGR ComplainMGR =new ComplainMGR();
        Complain complain = new Complain();
        boolean result ;
        ArrayList<Complain> ComplainList;

        complain.getComplainNo();
        complain.getComplainType();
        complain.getDescription();
        complain.getCreatedOn();
        complain.getModifiedOn();
        complain.getSyncDate();
        complain.getSyncStatus();

        result = ComplainMGR.DeleteData(complain,getBaseContext());
        ComplainList = ComplainMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_Complain = "+String.valueOf(result));
        Log.i("SelectData","Show_ComplainList = "+String.valueOf(ComplainList.size()));
        Log.d("Test Data", " Fiend complain Value = "+complain.getComplainNo());
        // Log.i("SelectData","Show "+String.valueOf(ClaimList.get(0).getAppId()));
        // Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 0 = "+String.valueOf(ComplainList.get(0).getComplainNo()));
        // Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 1 = "+String.valueOf(ComplainList.get(1).getComplainNo()));







    }

    public  void  DeleteNews(){


        NewsMGR newsMGR =new NewsMGR();
        News news = new News();
        boolean result ;
        ArrayList<News> NewsList;
//        NewsList = newsMGR.SelectData(getBaseContext());
//        news = NewsList.get(1);
//        Log.i("Opp_UpDateData"," Show RowId = "+news.getRowId());

        news.getNewsNo();
        news.getURL();
        news.getTitle();
        news.getDescription();
        news.getPicture();
        news.getCreatedOn();
        news.getModifiedOn();
        news.getStartDate();
        news.getEndDate();
        news.getSyncDate();
        news.getSyncStatus();


        result = newsMGR.DeleteData(news,getBaseContext());
        NewsList = newsMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_News = "+String.valueOf(result));
        Log.i("SelectData","Show_NewsList = "+String.valueOf(NewsList.size()));
        Log.d("Test Data", " Fiend news Value = "+news.getNewsNo());


    }

    public  void  DeleteOpportunityProduct(){

        OppurtunityProduct_MGR oppurtunityProduct_mgr =new OppurtunityProduct_MGR();
        OpportunityProduct opportunityProduct = new OpportunityProduct();
        boolean result ;
        ArrayList<OpportunityProduct> OpportunityProductList;

        opportunityProduct.getOpportunityProductNo();
        opportunityProduct.getProductNo();
        opportunityProduct.getProductType();
        opportunityProduct.getInsureType();
        opportunityProduct.getPercent();
        opportunityProduct.getPicture();
        opportunityProduct.getCreatedOn();
        opportunityProduct.getModifiedOn();
        opportunityProduct.getSyncDate();
        opportunityProduct.getSyncStatus();

        result = oppurtunityProduct_mgr.DeleteData(opportunityProduct,getBaseContext());
        OpportunityProductList = oppurtunityProduct_mgr.SelectDataPro(getBaseContext());
        Log.i("Opp_Delete","Show_Result_OpportunityProduct = "+String.valueOf(result));
        Log.i("SelectData","Show_OpportunityProductList = "+String.valueOf(OpportunityProductList.size()));
        Log.d("Test Data", " Fiend opportunityProduct Value = "+opportunityProduct.getOpportunityProductNo());

    }

    public  void  DeletePayment(){

        PaymentMGR paymentMGR =new PaymentMGR();
        Payment payment = new Payment();
        boolean result ;
        ArrayList<Payment> PaymentList;
        payment.getPaymentNo();
        payment.getPaymentType();
        payment.getPremium();
        payment.getAgentNo();
        payment.getInvoiceNo();
        payment.getCreatedOn();
        payment.getModifiedOn();
        payment.getSyncDate();
        payment.getSyncStatus();

        result = paymentMGR.DeleteData(payment,getBaseContext());
        PaymentList = paymentMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_Payment = "+String.valueOf(result));
        Log.i("SelectData","Show_PaymentList = "+String.valueOf(PaymentList.size()));
        Log.d("Test Data", " Fiend payment Value = "+payment.getPaymentNo());

    }

    public  void  DeletePolicy(){

        PolicyMGR policyMGR =new PolicyMGR();
        Policy policy = new Policy();
        boolean result ;
        ArrayList<Policy> PolicyList;
//
//        PolicyList = policyMGR.SelectData(getBaseContext());
//        policy = PolicyList.get(0);
//        Log.i("Opp_UpDateData"," Show RowId = "+policy.getRowId());
        policy.getAppId();
        policy.getPolicyStatus();
        policy.getStatus();
        policy.getCompany();
        policy.getPlan();
        policy.getStartDate();
        policy.getEndDate();
        policy.getFirstName();
        policy.getLastName();
        policy.getMobileNo();
        policy.getProvince();
        policy.getCardNo();
        policy.getPolicyCardNo();
        policy.getPayer();
        policy.getBirthDate();
        policy.getAge();
        policy.getAgeOnInsure();
        policy.getAgeInsure();
        policy.getAgentNo();
        policy.getAgentName();
        policy.getBranch();
        policy.getCliamNo();
        policy.getCreatedOn();
        policy.getModifiedOn();
        policy.getSyncDate();
        policy.getSyncStatus();

        result = policyMGR.DeleteData(policy,getBaseContext());
        PolicyList = policyMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_Policy = "+String.valueOf(result));
        Log.i("SelectData","Show_PolicyList = "+String.valueOf(PolicyList.size()));
        Log.d("Test Data", " Fiend policy Value = "+policy.getAppId());



    }

    public  void  DeleteProductContract(){

        ProductContactMGR productContactMGR =new ProductContactMGR();
        ProductContact productContact = new ProductContact();
        boolean result ;
        ArrayList<ProductContact> ProductConctList;
//        ProductConctList = productContactMGR.SelectData(getBaseContext());
//        productContact = ProductConctList.get(0);
//        Log.i("Opp_UpDateData"," Show RowId = "+productContact.getRowId());
        //productContact.getRowId();
        productContact.getUserID();
        productContact.getAgentCallDate();
        productContact.getPhoneNumber();
        productContact.getCreatedOn();
        productContact.getModifiedOn();
        productContact.getSyncDate();
        productContact.getSyncStatus();

        result = productContactMGR.DeleteData(productContact,getBaseContext());
        ProductConctList = productContactMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_ProductContact = "+String.valueOf(result));
        Log.i("SelectData","Show_ProductContactList = "+String.valueOf(ProductConctList.size()));
        Log.d("Test Data", " Fiend productContact Value = "+productContact.getUserID());


    }

    public  void  DeleteProductPromotion(){

        ProductPromotionMGR productPromotionMGR =new ProductPromotionMGR();
        ProductPromotion productPromotion = new ProductPromotion();
        boolean result ;
        ArrayList<ProductPromotion> ProductPromotionList;

        productPromotion.getProductNo();
        productPromotion.getProductName();
        productPromotion.getProductItem();
        productPromotion.getDescription();
        productPromotion.getProductType();
        productPromotion.getBenefit();
        productPromotion.getBirthDate();
        productPromotion.getCardNo();
        productPromotion.getCreatedOn();
        productPromotion.getModifiedOn();
        productPromotion.getSyncDate();
        productPromotion.getSyncStatus();

        result = productPromotionMGR.DeleteData(productPromotion,getBaseContext());
        ProductPromotionList = productPromotionMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_ProductPromotion = "+String.valueOf(result));
        Log.i("SelectData","Show_ProductPromotionList = "+String.valueOf(ProductPromotionList.size()));
        Log.d("Test Data", " Fiend productPromotion Value = "+productPromotion.getProductNo());


    }

    public  void  DeleteProductSale(){

        ProductSalesMGR productSalesMGR =new ProductSalesMGR();
        ProductSales productSales = new ProductSales();
        boolean result ;
        ArrayList<ProductSales> ProductSalesList;

        productSales.getProductSalesNo();
        productSales.getAppId();
        productSales.getProductNo();
        productSales.getPolicyMonth();
        productSales.getPolicyYear();
        productSales.getScreenDate();
        productSales.getRelationCustomer();
        productSales.getCardNo();
        productSales.getCustmerName();
        productSales.getCareer();
        productSales.getCareerLavel();
        productSales.getPhoneNumber();
        productSales.getEmail();
        productSales.getAddress();
        productSales.getPaymentType();
        productSales.getPremium();
        productSales.getAgentNo();
        productSales.getInvoiceNo();
        productSales.getCreatedOn();
        productSales.getModifiedOn();
        productSales.getSyncDate();
        productSales.getSyncStatus();

        result = productSalesMGR.DeleteData(productSales,getBaseContext());
        ProductSalesList = productSalesMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_ProductSales = "+String.valueOf(result));
        Log.i("SelectData","Show_ProductSalesList = "+String.valueOf(ProductSalesList.size()));
        Log.d("Test Data", " Fiend productSales Value = "+productSales.getProductSalesNo());


    }

    public  void  DeleteUsers(){

        UsersMGR usersMGR =new UsersMGR();
        Users users = new Users();
        boolean result ;
        ArrayList<Users> UsersList;
        users.getUserID();
        users.getUserLogin();
        users.getPassword();
        users.getFirstName();
        users.getLastName();
        users.getCardNo();
        users.getBirthDate();
        users.getEmail();
        users.getPhoneNumber1();
        users.getPhoneNumber2();
        users.getHomeAddress1();
        users.getWorkAddress2();
        users.getHomeAddress2();
        users.getWorkAddress1();
        users.getHomeSubdistrict();
        users.getHomeDistrict();
        users.getHomeZipCode();
        users.getWorkSubdistrict();
        users.getWorkDistrict();
        users.getWorkZipCode();
        users.getAgentSubdistrict();
        users.getAgentDistrict();
        users.getAgentProvice();
        users.getUserType();
        users.getPicture();
        users.getCreatedOn();
        users.getModifiedOn();
        users.getSyncDate();
        users.getSyncStatus();

        result = usersMGR.DeleteData(users,getBaseContext());
        UsersList = usersMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_Users = "+String.valueOf(result));
        Log.i("SelectData","Show_UsersList = "+String.valueOf(UsersList.size()));
        Log.d("Test Data", " Fiend users Value = "+users.getUserID());


    }

    public  void  DeleteProductItem(){

        ProductItemMGR productItemMGR =new ProductItemMGR();
        ProductItem productItem = new ProductItem();
        boolean result ;
        ArrayList<ProductItem> ProductItemList;
        productItem.getProductItemNo();
        productItem.getProductItemName();
        productItem.getProductNo();
        productItem.getCreatedOn();
        productItem.getModifiedOn();
        productItem.getSyncDate();
        productItem.getSyncStatus();

        result = productItemMGR.DeleteData(productItem,getBaseContext());
        ProductItemList = productItemMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_ProductItem = "+String.valueOf(result));
        Log.i("SelectData","Show_ProductItemList = "+String.valueOf(ProductItemList.size()));
        Log.d("Test Data", " Fiend productItem Value = "+productItem.getProductItemNo());

    }

    public  void  DeleteContent(){


        ContentMGR contentMGR =new ContentMGR();
        Content content = new Content();
        boolean result ;
        ArrayList<Content> ContentList;
        //ContentList = contentMGR.SelectData(getBaseContext());
        //content = ContentList.get(0);
        //content.setRowId("");

        content.getContentNo();
        content.getTitle();
        content.getDescription();
        content.getPicture();
        content.getCreatedOn();
        content.getModifiedOn();
        content.getSyncDate();
        content.getSyncStatus();

        result = contentMGR.DeleteData(content,getBaseContext());
        ContentList = contentMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_Content = "+String.valueOf(result));
        Log.i("SelectData","Show_ContentList = "+String.valueOf(ContentList.size()));
        Log.d("Test Data", " Fiend content Value = "+content.getContentNo());
        //Log.i("ComplainNo_SelectData","Show_ComplainNoList_Recode 0 = "+String.valueOf(ContentList2.get(0).getContentNo()));



    }

    public  void  DeleteOpportunity(){

        OpportunityMGR opportunityMGR =new OpportunityMGR();
        Opportunity opportunity = new Opportunity();
        boolean result ;
        ArrayList<Opportunity> OpportunityList;

        opportunity.getOpportunityNo();
        opportunity.getFirstName();
        opportunity.getLastName();
        opportunity.getCardNo();
        opportunity.getPhoneNumber1();
        opportunity.getPhoneNumber2();
        opportunity.getEmail();
        opportunity.getLineId();
        opportunity.getAddress();
        opportunity.getProvince();
        opportunity.getRemark();
        opportunity.getPicture();
        opportunity.getGPSLat();
        opportunity.getGPSLong();
        opportunity.getOpportunityType();
        opportunity.getCause();
        opportunity.getPictureType();
        opportunity.getInstitute();
        opportunity.getPlace();
        opportunity.getDistrict();
        opportunity.getSubDistrict();
        opportunity.getProvince();
        opportunity.getAgentNo();
        opportunity.getCreatedOn();
        opportunity.getModifiedOn();
        opportunity.getSyncDate();
        opportunity.getSyncStatus();

        result = opportunityMGR.DeleteData(opportunity,getBaseContext());
        OpportunityList = opportunityMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_Opportunity = "+String.valueOf(result));
        Log.i("SelectData","Show_OpportunityList = "+String.valueOf(OpportunityList.size()));
        Log.d("Test Data", " Fiend opportunity Value = "+opportunity.getOpportunityNo());



    }

    public  void  DeleteTask(){

        TaskMGR taskMGR =new TaskMGR();
        Task task = new Task();
        boolean result ;
        ArrayList<Task> TaskList;

        task.getTaskNo();
        task.getTitle();
        task.getDescription();
        task.getAgentNo();
        task.getCreatedOn();
        task.getModifiedOn();
        task.getSyncDate();
        task.getSyncStatus();

        result = taskMGR.DeleteData(task,getBaseContext());
        TaskList = taskMGR.SelectData(getBaseContext());
        Log.i("Opp_Delete","Show_Result_Task = "+String.valueOf(result));
        Log.i("SelectData","Show_TaskList = "+String.valueOf(TaskList.size()));
        Log.d("Test Data", " Fiend task Value = "+task.getTaskNo());



    }

}

