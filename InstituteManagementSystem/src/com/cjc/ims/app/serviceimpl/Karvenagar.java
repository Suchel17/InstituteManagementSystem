package com.cjc.ims.app.serviceimpl;

import java.util.*;
import com.cjc.ims.app.model.*;
import com.cjc.ims.app.servicei.Cjc;

public class Karvenagar implements Cjc {

    List<Course> clist = new ArrayList<>();
    List<Faculty> flist = new ArrayList<>();
    List<Batch> blist = new ArrayList<>();
    List<Student> slist = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // ------------------ COURSE ----------------------

    public void addCourse() {
        Course c = new Course();

        System.out.print("Enter Course ID: ");
        c.setCid(sc.nextInt());

        System.out.print("Enter Course Name: ");
        c.setCname(sc.next());

        clist.add(c);
        System.out.println("Course Added Successfully\n");
    }

    public void viewCourse() {
        System.out.println("----- Course List -----");
        for (Course c : clist) {
            System.out.println(c.getCid() + "  " + c.getCname());
        }
        System.out.println();
    }

    // ------------------ FACULTY ----------------------

    public void addFaculty() {
        Faculty f = new Faculty();

        System.out.print("Enter Faculty ID: ");
        f.setFid(sc.nextInt());

        System.out.print("Enter Faculty Name: ");
        f.setFname(sc.next());

        System.out.println("Select Course for Faculty:");
        viewCourse();

        System.out.print("Enter Course ID: ");
        int cid = sc.nextInt();

        for (Course c : clist) {
            if (c.getCid() == cid) {
                f.setCourse(c);
            }
        }

        flist.add(f);
        System.out.println("Faculty Added Successfully\n");
    }

    public void viewFaculty() {
        System.out.println("----- Faculty List -----");
        for (Faculty f : flist) {
            System.out.println(f.getFid() + "  " + f.getFname() + "  Course: " + f.getCourse().getCname());
        }
        System.out.println();
    }

    // ------------------ BATCH ----------------------

    public void addBatch() {
        Batch b = new Batch();

        System.out.print("Enter Batch ID: ");
        b.setBid(sc.nextInt());

        System.out.print("Enter Batch Name: ");
        b.setBname(sc.next());

        System.out.println("Select Faculty for Batch:");
        viewFaculty();

        System.out.print("Enter Faculty ID: ");
        int fid = sc.nextInt();

        for (Faculty f : flist) {
            if (f.getFid() == fid) {
                b.setFaculty(f);
            }
        }

        blist.add(b);
        System.out.println("Batch Added Successfully\n");
    }

    public void viewBatch() {
        System.out.println("----- Batch List -----");
        for (Batch b : blist) {
            System.out.println(
                b.getBid() + "  " + b.getBname() + "  Faculty: " + b.getFaculty().getFname()
            );
        }
        System.out.println();
    }

    // ------------------ STUDENT ----------------------

    public void addStudent() {
        Student s = new Student();

        System.out.print("Enter Student ID: ");
        s.setSid(sc.nextInt());

        System.out.print("Enter Student Name: ");
        s.setSname(sc.next());

        System.out.println("Select Batch for Student:");
        viewBatch();

        System.out.print("Enter Batch ID: ");
        int bid = sc.nextInt();

        for (Batch b : blist) {
            if (b.getBid() == bid) {
                s.setBatch(b);
            }
        }

        slist.add(s);
        System.out.println("Student Added Successfully\n");
    }

    public void viewStudent() {
        System.out.println("----- Student List -----");
        for (Student s : slist) {
            System.out.println(
                s.getSid() + "  " + s.getSname() +
                "  Batch: " + s.getBatch().getBname()
            );
        }
        System.out.println();
    }
}



