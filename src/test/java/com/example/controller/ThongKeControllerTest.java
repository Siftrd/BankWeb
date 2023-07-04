//package com.example.controller;
//
//import com.example.dao.TKDAO;
//import com.example.model.SotietkiemModel;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class ThongKeControllerTest {
//    @InjectMocks
//    private ThongKeController tk = new ThongKeController();
//    @Mock
//    private HttpServletRequest req;
//    @Mock
//    private HttpServletResponse resp;
//    @Mock
//    private TKDAO dao;
//    @Mock
//    private RequestDispatcher rd;
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void doGet() throws ServletException, IOException {
//        String beginDate = "2023-04-01";
//        String endDate = "2023-10-11";
//        int maxItemPage = 2;
//        int currentPage = 1;
//        int count = 3;
//        List<SotietkiemModel> list = new ArrayList<>();
//
//        when(req.getParameter("datebegin")).thenReturn(beginDate);
//        when(req.getParameter("dateend")).thenReturn(endDate);
//        when(req.getParameter("page")).thenReturn(String.valueOf(currentPage));
//        when(dao.getTotalItem(beginDate,endDate)).thenReturn(count);
//        when(dao.findAll(beginDate,endDate,currentPage,maxItemPage)).thenReturn(list);
//        when(req.getRequestDispatcher("views/deposit.jsp")).thenReturn(rd);
//
//        tk.doGet(req,resp);
//
//        int expectedTotalPage = 2;
//        int actualTotalPage = (int) Math.ceil((double) count / maxItemPage);
//        assertEquals(expectedTotalPage, actualTotalPage);
//
//        verify(req).setAttribute("begin", beginDate);
//        verify(req).setAttribute("end", endDate);
//        verify(req).setAttribute("page", currentPage);
//        verify(req).setAttribute("list", list);
//        verify(rd).forward(req, resp);
//    }
//}