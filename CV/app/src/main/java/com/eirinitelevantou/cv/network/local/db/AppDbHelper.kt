package com.eirinitelevantou.cv.network.local.db


import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable
import io.realm.Realm
import java.text.Normalizer

/**
 * The class will contain methods to access REALM and return or create data
 */

@Singleton
class AppDbHelper @Inject
constructor(private val realm: Realm) : DbHelper {
//
//    override val allUsers: Observable<List<User>>
//        get() = Observable.fromCallable { realm.where(User::class.java).findAll() }
//
//    override val forms: List<Normalizer.Form>
//        get() = realm.where(Normalizer.Form::class.java).findAll()
//
//
//    override val user: User?
//        get() = realm.where(User::class.java).findFirst()
//
//    override fun addUser(user: User) {
//        realm.executeTransaction { realm -> realm.copyToRealmOrUpdate(user) }
//    }
//
//    override fun updateUser(user: User, firstName: String, surname: String, sex: Int, age: Int, hometown: String, positionId: Int, phone: String) {
//        realm.executeTransaction { realm ->
//            user.name = firstName
//            user.surname = surname
//            user.age = sex
//            user.gender = sex
//            user.age = age
//            user.homeTown = hometown
//            user.usualPosition = positionId
//            user.phone = phone
//            realm.copyToRealmOrUpdate(user)
//        }
//    }
//
//    override fun deleteAll() {
//        realm.executeTransaction { realm -> realm.deleteAll() }
//    }
//
//    override fun getTab(tabId: Long): Tab? {
//        return realm.where(Tab::class.java).equalTo("tabId", tabId).findFirst()
//    }
//
//    override fun getFormWithId(formId: Int): Form? {
//        return realm.where(Form::class.java).equalTo("id", formId).findFirst()
//
//    }
//
//    override fun getPageWithId(pageId: Int): Page? {
//        return realm.where(Page::class.java).equalTo("pageId", pageId).findFirst()
//
//    }
//
//
//    override fun addForms(forms: List<Form>) {
//        realm.executeTransaction { realm ->
//            realm.copyToRealmOrUpdate(forms)
//            for (form in forms) {
//                realm.copyToRealmOrUpdate(form.pages)
//
//                for (page in form.pages!!) {
//                    realm.copyToRealmOrUpdate(page.tabs)
//
//                }
//            }
//        }
//    }


}
