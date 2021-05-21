package com.example;

import com.example.domain.orderdetail.OrderDetail;
import com.example.domain.orderdetail.OrderDetailCreateRequest;
import com.example.domain.ordergroup.OrderGroup;
import com.example.domain.item.Item;
import com.example.domain.item.ItemCreateRequest;
import com.example.domain.ordergroup.OrderGroupCreateRequest;
import com.example.domain.user.User;
import com.example.domain.user.UserCreateRequest;
import com.example.repository.ItemRepository;
import com.example.repository.OrderDetailRepository;
import com.example.repository.OrderGroupRepository;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CreateSample extends AppTest {
    private Random random;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    //Item
    private static final String NAME = "name";
    private static final String TITLE = "title";
    private static final String TEXT = "text";
    private static final BigDecimal PRICE = BigDecimal.valueOf(100);
    private static final String BRAND_NAME = "brand";

    //User
    private static final String ACCOUNT = "account";
    private static final String PASSWORD = "password";
    private static final String STATUS = "created";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phoneNumber";

    //OrderGroup
    private static final String ORDER_TYPE = "orderType";
    private static final String REV_ADDRESS = "revAddress";
    private static final String REV_NAME = "revName";
    private static final String PAYMENT_TYPE = "paymentType";
    private static final BigDecimal TOTAL_PRICE = BigDecimal.valueOf(100);
    private static final int TOTAL_QUANTITY = 100;
    private static final LocalDateTime ORDER_AT = LocalDateTime.now();
    private static final LocalDateTime ARRIVAL_DATE = LocalDateTime.now().plusDays(3);

    //OrderDetail
    private static final int QUANTITY = 5;

    @BeforeEach
    public void setUp() {
        random = new Random();
    }

    @Test
    @Disabled
    public void init() {
        userRepository.deleteAll();
        itemRepository.deleteAll();
        orderGroupRepository.deleteAll();
        orderDetailRepository.deleteAll();
    }

    @Test
    @Order(1)
    public void createItem() {
        for(int i=1; i<100; i++) {
            ItemCreateRequest itemCreateRequest = ItemCreateRequest.builder()
                    .status(STATUS + i)
                    .name(NAME + i)
                    .title(TITLE + i)
                    .text(TEXT + i)
                    .price(PRICE)
                    .brandName(BRAND_NAME + i)
                    .build();

            Item item = itemCreateRequest.toEntity();
            itemRepository.save(item);
        }
    }

    @Test
    @Order(2)
    public void createUser() {
        for(int i=1; i<10; i++) {
            UserCreateRequest userCreateRequest = UserCreateRequest.builder()
                    .account(ACCOUNT + i)
                    .password(PASSWORD + i)
                    .status(STATUS + i)
                    .email(EMAIL + i)
                    .phoneNumber(PHONE_NUMBER + i)
                    .build();

            User user = userCreateRequest.toEntity();
            userRepository.save(user);
        }
    }

    @Test
    @Order(3)
    public void createOrder() {
        User user = userRepository.findById(100L)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        int orderCount = 3;
        for(int k=0; k<orderCount; k++) {
            double totalAmount = 0;

            List<Item> items = new ArrayList<>();
            List<OrderDetail> orderHistoryDetails = new ArrayList<>();

            int itemCount = 3;
            for(int i=0; i<itemCount; i++) {
                int itemNumber = random.nextInt(90) + 1;

                Item item = itemRepository.findById((long)itemNumber).get();
                totalAmount += item.getPrice().doubleValue();
                items.add(item);
            }

            OrderGroupCreateRequest orderGroupCreateRequest = OrderGroupCreateRequest.builder()
                    .status(STATUS)
                    .orderType(ORDER_TYPE)
                    .revAddress(REV_ADDRESS)
                    .revName(REV_NAME)
                    .paymentType(PAYMENT_TYPE)
                    .totalPrice(BigDecimal.valueOf(totalAmount))
                    .totalQuantity(TOTAL_QUANTITY)
                    .orderAt(ORDER_AT)
                    .arrivalDate(ARRIVAL_DATE)
                    .user(user)
                    .orderDetailList(orderHistoryDetails)
                    .build();

            OrderGroup orderGroup = orderGroupCreateRequest.toEntity();
//            orderGroup.setUser(user);
//            orderGroup.setOrderDetailList(orderHistoryDetails);

            orderGroupRepository.save(orderGroup);

            for(Item item : items) {
                OrderDetailCreateRequest orderDetailCreateRequest = OrderDetailCreateRequest.builder()
                        .status(STATUS)
                        .arrivalDate(ARRIVAL_DATE)
                        .quantity(QUANTITY)
                        .totalPrice(TOTAL_PRICE)
                        .orderGroup(orderGroup)
                        .item(item)
                        .build();

                OrderDetail orderDetail = orderDetailCreateRequest.toEntity();
//                orderDetail.setOrderGroup(orderGroup);
//                orderDetail.setItem(item);

                orderDetailRepository.save(orderDetail);
                orderHistoryDetails.add(orderDetail);
            }
        }
    }

    public void item(User user) {
        double totalAmount = 0;

        List<Item> items = new ArrayList<>();
        List<OrderDetail> orderHistoryDetails = new ArrayList<>();

        int itemCount = 3;
        for(int i=0; i<itemCount; i++) {
            int itemNumber = random.nextInt(90) + 1;

            Item item = itemRepository.findById((long)itemNumber).get();
            totalAmount += item.getPrice().doubleValue();
            items.add(item);
        }

        OrderGroupCreateRequest orderGroupCreateRequest = OrderGroupCreateRequest.builder()
                .status(STATUS)
                .orderType(ORDER_TYPE)
                .revAddress(REV_ADDRESS)
                .revName(REV_NAME)
                .paymentType(PAYMENT_TYPE)
                .totalPrice(BigDecimal.valueOf(totalAmount))
                .totalQuantity(TOTAL_QUANTITY)
                .orderAt(ORDER_AT)
                .arrivalDate(ARRIVAL_DATE)
                .build();

        OrderGroup orderGroup = orderGroupCreateRequest.toEntity();
        orderGroup.setUser(user);
        orderGroup.setOrderDetailList(orderHistoryDetails);

        orderGroupRepository.save(orderGroup);

        for(Item item : items) {
            OrderDetailCreateRequest orderDetailCreateRequest = OrderDetailCreateRequest.builder()
                    .status(STATUS)
                    .arrivalDate(ARRIVAL_DATE)
                    .quantity(QUANTITY)
                    .totalPrice(TOTAL_PRICE)
                    .build();

            OrderDetail orderDetail = orderDetailCreateRequest.toEntity();
            orderDetail.setOrderGroup(orderGroup);
            orderDetail.setItem(item);

            orderDetailRepository.save(orderDetail);
            orderHistoryDetails.add(orderDetail);
        }
    }
}
