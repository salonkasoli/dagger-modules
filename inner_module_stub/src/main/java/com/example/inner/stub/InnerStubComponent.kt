package com.example.inner.stub

import com.example.di.FeatureComponent
import com.example.inner.api.InnerApi
import com.example.inner.api.InnerRepository

class InnerStubComponent : FeatureComponent, InnerApi {

    override fun getRepo(): InnerRepository {
        TODO("Not yet implemented")
    }
}