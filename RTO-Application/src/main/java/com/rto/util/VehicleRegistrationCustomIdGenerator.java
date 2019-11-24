package com.rto.util;

import java.io.Serializable;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;


public class VehicleRegistrationCustomIdGenerator implements IdentifierGenerator, Configurable{

    private String sequenceCallSyntax;
    private static final Logger logger=Logger.getLogger(VehicleRegistrationCustomIdGenerator.class);
 
    @Override
    public void configure(
            Type type,
            Properties params,
            ServiceRegistry serviceRegistry)
        throws MappingException {
 
        final JdbcEnvironment jdbcEnvironment = serviceRegistry
        .getService(
            JdbcEnvironment.class
        );
 
        final Dialect dialect = jdbcEnvironment.getDialect();
 
        final String sequencePerEntitySuffix = ConfigurationHelper
        .getString(
            SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
            params,
            SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX
        );
 
        boolean preferSequencePerEntity = ConfigurationHelper
        .getBoolean(
            SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY,
            params,
            false
        );
 
        final String defaultSequenceName = preferSequencePerEntity
            ? params.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix
            : SequenceStyleGenerator.DEF_SEQUENCE_NAME;
 
        sequenceCallSyntax = dialect
        .getSequenceNextValString(
            ConfigurationHelper.getString(
                SequenceStyleGenerator.SEQUENCE_PARAM,
                params,
                defaultSequenceName
            )
        );
    }
 
    @Override
    public Serializable generate(
            SharedSessionContractImplementor session,
            Object obj) {
    	
    	logger.info("entered into generate() method to generate custom id for RegNumber");
             
        if (obj instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) obj;
            Serializable id = identifiable.getId();
 
            if (id != null) {
                return id;
            }
        }
 
        long seqValue = ((Number)
            Session.class.cast(session)
            .createNativeQuery(sequenceCallSyntax)
            .uniqueResult()
        ).longValue();
 
        //return sequencePrefix + String.format("%011d%s", 0 ,seqValue);
        Serializable regNum= RandomStringUtil.getRandomString(2)+" "+seqValue+" "+RandomStringUtil.getRandomString(3);
        logger.info("exiting from generate() method with custom RegNum: "+regNum);
        return regNum;
    }
}
