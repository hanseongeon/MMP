package com.example.MMP.siteuser;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSiteUser is a Querydsl query type for SiteUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSiteUser extends EntityPathBase<SiteUser> {

    private static final long serialVersionUID = 1960345023L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSiteUser siteUser = new QSiteUser("siteUser");

    public final ListPath<com.example.MMP.alarm.Alarm, com.example.MMP.alarm.QAlarm> alarmList = this.<com.example.MMP.alarm.Alarm, com.example.MMP.alarm.QAlarm>createList("alarmList", com.example.MMP.alarm.Alarm.class, com.example.MMP.alarm.QAlarm.class, PathInits.DIRECT2);

    public final ListPath<com.example.MMP.challenge.attendance.Attendance, com.example.MMP.challenge.attendance.QAttendance> attendanceList = this.<com.example.MMP.challenge.attendance.Attendance, com.example.MMP.challenge.attendance.QAttendance>createList("attendanceList", com.example.MMP.challenge.attendance.Attendance.class, com.example.MMP.challenge.attendance.QAttendance.class, PathInits.DIRECT2);

    public final StringPath birthDate = createString("birthDate");

    public final NumberPath<Integer> bonus = createNumber("bonus", Integer.class);

    public final SetPath<com.example.MMP.challengeGroup.ChallengeGroup, com.example.MMP.challengeGroup.QChallengeGroup> challengeGroups = this.<com.example.MMP.challengeGroup.ChallengeGroup, com.example.MMP.challengeGroup.QChallengeGroup>createSet("challengeGroups", com.example.MMP.challengeGroup.ChallengeGroup.class, com.example.MMP.challengeGroup.QChallengeGroup.class, PathInits.DIRECT2);

    public final ListPath<com.example.MMP.challenge.challengeUser.ChallengeUser, com.example.MMP.challenge.challengeUser.QChallengeUser> challengeUsers = this.<com.example.MMP.challenge.challengeUser.ChallengeUser, com.example.MMP.challenge.challengeUser.QChallengeUser>createList("challengeUsers", com.example.MMP.challenge.challengeUser.ChallengeUser.class, com.example.MMP.challenge.challengeUser.QChallengeUser.class, PathInits.DIRECT2);

    public final ListPath<com.example.MMP.chat.ChatRoom, com.example.MMP.chat.QChatRoom> chatRoomList = this.<com.example.MMP.chat.ChatRoom, com.example.MMP.chat.QChatRoom>createList("chatRoomList", com.example.MMP.chat.ChatRoom.class, com.example.MMP.chat.QChatRoom.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> createDate = createDate("createDate", java.time.LocalDate.class);

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.example.MMP.lesson.Lesson, com.example.MMP.lesson.QLesson> lessonList = this.<com.example.MMP.lesson.Lesson, com.example.MMP.lesson.QLesson>createList("lessonList", com.example.MMP.lesson.Lesson.class, com.example.MMP.lesson.QLesson.class, PathInits.DIRECT2);

    public final ListPath<com.example.MMP.lesson.Lesson, com.example.MMP.lesson.QLesson> lessonsAttending = this.<com.example.MMP.lesson.Lesson, com.example.MMP.lesson.QLesson>createList("lessonsAttending", com.example.MMP.lesson.Lesson.class, com.example.MMP.lesson.QLesson.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath number = createString("number");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> performancePay = createNumber("performancePay", Integer.class);

    public final com.example.MMP.point.QPoint point;

    public final com.example.MMP.ptGroup.QPtGroup ptGroupTrainer;

    public final ListPath<com.example.MMP.ptGroup.PtGroup, com.example.MMP.ptGroup.QPtGroup> ptGroupUser = this.<com.example.MMP.ptGroup.PtGroup, com.example.MMP.ptGroup.QPtGroup>createList("ptGroupUser", com.example.MMP.ptGroup.PtGroup.class, com.example.MMP.ptGroup.QPtGroup.class, PathInits.DIRECT2);

    public final ListPath<SiteUser, QSiteUser> referrals = this.<SiteUser, QSiteUser>createList("referrals", SiteUser.class, QSiteUser.class, PathInits.DIRECT2);

    public final QSiteUser referrer;

    public final NumberPath<Integer> salary = createNumber("salary", Integer.class);

    public final ListPath<com.example.MMP.homeTraining.HomeTraining, com.example.MMP.homeTraining.QHomeTraining> saveTraining = this.<com.example.MMP.homeTraining.HomeTraining, com.example.MMP.homeTraining.QHomeTraining>createList("saveTraining", com.example.MMP.homeTraining.HomeTraining.class, com.example.MMP.homeTraining.QHomeTraining.class, PathInits.DIRECT2);

    public final ListPath<com.example.MMP.transPass.TransPass, com.example.MMP.transPass.QTransPass> transPassList = this.<com.example.MMP.transPass.TransPass, com.example.MMP.transPass.QTransPass>createList("transPassList", com.example.MMP.transPass.TransPass.class, com.example.MMP.transPass.QTransPass.class, PathInits.DIRECT2);

    public final ListPath<com.example.MMP.usercoupon.UserCoupon, com.example.MMP.usercoupon.QUserCoupon> userCouponList = this.<com.example.MMP.usercoupon.UserCoupon, com.example.MMP.usercoupon.QUserCoupon>createList("userCouponList", com.example.MMP.usercoupon.UserCoupon.class, com.example.MMP.usercoupon.QUserCoupon.class, PathInits.DIRECT2);

    public final ListPath<com.example.MMP.userPass.UserDayPass, com.example.MMP.userPass.QUserDayPass> userDayPassList = this.<com.example.MMP.userPass.UserDayPass, com.example.MMP.userPass.QUserDayPass>createList("userDayPassList", com.example.MMP.userPass.UserDayPass.class, com.example.MMP.userPass.QUserDayPass.class, PathInits.DIRECT2);

    public final StringPath userId = createString("userId");

    public final ListPath<com.example.MMP.userPass.UserPtPass, com.example.MMP.userPass.QUserPtPass> userPtPassList = this.<com.example.MMP.userPass.UserPtPass, com.example.MMP.userPass.QUserPtPass>createList("userPtPassList", com.example.MMP.userPass.UserPtPass.class, com.example.MMP.userPass.QUserPtPass.class, PathInits.DIRECT2);

    public final StringPath userRole = createString("userRole");

    public QSiteUser(String variable) {
        this(SiteUser.class, forVariable(variable), INITS);
    }

    public QSiteUser(Path<? extends SiteUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSiteUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSiteUser(PathMetadata metadata, PathInits inits) {
        this(SiteUser.class, metadata, inits);
    }

    public QSiteUser(Class<? extends SiteUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.point = inits.isInitialized("point") ? new com.example.MMP.point.QPoint(forProperty("point"), inits.get("point")) : null;
        this.ptGroupTrainer = inits.isInitialized("ptGroupTrainer") ? new com.example.MMP.ptGroup.QPtGroup(forProperty("ptGroupTrainer"), inits.get("ptGroupTrainer")) : null;
        this.referrer = inits.isInitialized("referrer") ? new QSiteUser(forProperty("referrer"), inits.get("referrer")) : null;
    }

}

